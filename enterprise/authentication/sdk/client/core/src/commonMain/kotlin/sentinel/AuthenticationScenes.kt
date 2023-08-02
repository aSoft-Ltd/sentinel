@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import kotlin.js.JsExport

interface AuthenticationScenes {
    val signIn: SignInScene
    val barrier: BarrierScene
    val registration: RegistrationScene
}