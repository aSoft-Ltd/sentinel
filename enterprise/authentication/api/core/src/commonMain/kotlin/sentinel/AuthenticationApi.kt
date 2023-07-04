@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import koncurrent.Later
import sentinel.params.SignInParams
import kotlin.js.JsExport

interface AuthenticationApi {
    fun signIn(params: SignInParams): Later<UserSession>
    fun session(): Later<UserSession>
    fun signOut(): Later<Unit>
}