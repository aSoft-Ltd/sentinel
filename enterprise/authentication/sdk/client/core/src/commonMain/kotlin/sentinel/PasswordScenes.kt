@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import kotlin.js.JsExport

class PasswordScenes(config: AuthenticationScenesConfig<AuthenticationApi>) {
    val forgot by lazy { PasswordForgotScene(config) }
    val reset by lazy { PasswordResetScene(config) }
}