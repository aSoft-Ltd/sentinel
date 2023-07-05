package sentinel

import geo.GeoLocation
import identifier.CorporateBranchDto
import identifier.CorporateDto
import io.ktor.client.request.*
import io.ktor.client.statement.*
import keep.load
import keep.save
import koncurrent.Later
import koncurrent.later
import koncurrent.later.await
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import pione.ApiConfigRestKtor
import pione.PiOneConstants
import pione.PiOneEndpoint
import pione.PiOneResponseException
import pione.content
import pione.response.PiOneFailureResponse
import pione.response.PiOneSingleDataSuccessResponse
import sentinel.params.SignInParams

class AuthenticationApiPiOne(
    private val config: ApiConfigRestKtor<PiOneEndpoint>
) : AuthenticationApi {
    private val client get() = config.http
    private val path get() = config.endpoint
    private val codec get() = config.codec
    private val cache get() = config.cache

    override fun signIn(params: SignInParams): Later<UserSession> = config.scope.later {
        config.logger.info("Signing `${params.email}` in")
        client.post(path.signin) {
            setBody(params.toJson())
        }.bodyAsText().toPiOneResponse().also {
            cache.save(PiOneConstants.SECRET_CACHE_KEY, it.secret).await()
            cache.save(PiOneConstants.CUSTOMER_DOMAIN_KEY, it.hostDetails.companyUrl).await()
        }

        session().await()
    }

    override fun session(): Later<UserSession> = config.scope.later {
        client.post(path().corporateSession) {
            val content = config.content(PiOneEndpoint.DataType.None, mapOf<String, String>())
            setBody(content)
        }.parseSession()
    }

    suspend fun HttpResponse.parseSession(): UserSession {
        val text = bodyAsText()
        println(text)
        return if (codec.decodeFromString<JsonObject>(text).isSuccess) {
            codec.decodeFromString(PiOneSingleDataSuccessResponse.serializer(UserSession.serializer()), text).obj
        } else {
            throw parseError(text)
        }
    }

    private fun SignInParams.toJson() = """{ "username": "$email", "password": "$password" }"""

    private fun String.toPiOneResponse() = codec.decodeFromString(PiOneSignInResponse.serializer(), this)

    override fun signOut(): Later<Unit> {
        config.logger.info("Signing out")
        return cache.remove(PiOneConstants.SECRET_CACHE_KEY).andThen {
            cache.remove(PiOneConstants.CUSTOMER_DOMAIN_KEY)
        }.then {
            config.logger.info("Signed out")
        }.catch {
            config.logger.error("Failed to sign out", it)
        }
    }

    private fun parseError(text: String): PiOneResponseException = try {
        val cause = codec.decodeFromString(PiOneFailureResponse.serializer(), text)
        PiOneResponseException(cause.error)
    } catch (err: Exception) {
        PiOneResponseException(text)
    }

    private val JsonObject.isSuccess get() = get("status")?.jsonPrimitive?.content == "ok"

    suspend fun path(): PiOneEndpoint {
        val companyUrl = config.cache.load<String>(PiOneConstants.CUSTOMER_DOMAIN_KEY).await()
        return config.endpoint.copy(root = companyUrl)
    }
}