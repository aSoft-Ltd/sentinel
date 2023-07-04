@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import koncurrent.Later
import sentinel.fields.SetPasswordFields
import symphony.toForm
import symphony.toSubmitConfig
import kotlin.js.JsExport

class SetPasswordScene(private val config: OnboardingScenesConfig<ProfileApi>) {
    private var successFunction: (() -> Unit)? = null

    fun initialize(onSuccess: () -> Unit) {
        successFunction = onSuccess
    }

    fun deInitialize() {
        successFunction = null
    }

    val form = SetPasswordFields().toForm(
        heading = "Make your account secure",
        details = "Set up your new password",
        config = config.toSubmitConfig()
    ) {
        onSubmit { output ->
            Later(output).andThen {
                config.api.personal.changePassword(it.toParams())
            }
        }

        onSuccess { successFunction?.invoke() }
    }
}