@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import koncurrent.Later
import sentinel.params.SignUpParams
import sentinel.params.VerificationParams
import kotlin.js.JsExport

interface SignUpApi {

    fun signUp(params: SignUpParams): Later<SignUpParams>

    fun verify(params: VerificationParams): Later<VerificationParams>

    // One might think this should be coupled to signup method, but we separated them to be able to
    // (re)send the verification link multiple times
    // i.e. Did not get a verification link?? Click here to send again
    fun sendVerificationLink(email: String): Later<String>
}