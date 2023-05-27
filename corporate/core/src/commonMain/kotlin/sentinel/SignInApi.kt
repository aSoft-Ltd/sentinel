@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import koncurrent.Later
import sentinel.params.SignInParams
import kotlin.js.JsExport

interface SignInApi {
    fun signIn(params: SignInParams): Later<UserSession>
}