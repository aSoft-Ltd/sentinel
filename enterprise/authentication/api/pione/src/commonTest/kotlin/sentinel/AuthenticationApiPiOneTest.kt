package sentinel

import koncurrent.later.await
import kotlinx.coroutines.test.runTest
import kotlin.test.Test


class AuthenticationApiPiOneTest {
    val api = AuthenticationApiProviderPiOneTest()

    @Test
    fun should_send_password_reset_email() = runTest {
        api.sendPasswordResetLink("george.sechu@gmail.com").await()
    }
}