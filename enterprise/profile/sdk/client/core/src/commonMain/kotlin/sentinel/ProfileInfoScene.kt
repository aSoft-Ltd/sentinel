@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import cinematic.LazyScene
import geo.Country
import identifier.IndividualDto
import identifier.IndividualPresenter
import identifier.fields.IndividualFields
import identifier.fields.IndividualOutput
import identifier.transformers.toPresenter
import kase.Loading
import kase.toLazyState
import koncurrent.later.finally
import koncurrent.toLater
import sentinel.transformers.toProfileParams
import symphony.Form
import symphony.toForm
import symphony.toSubmitConfig
import kotlin.js.JsExport

class ProfileInfoScene(
    private val config: ProfileScenesConfig<ProfileApiProvider>
) : LazyScene<Form<IndividualDto,IndividualOutput,IndividualFields>>() {

    fun initialize() = Unit.toLater().andThen {
        ui.value = Loading("fetching your info")
        config.api.settings()
    }.then {
        form(it.user.toPresenter(),it.country)
    }.finally {
        ui.value = it.toLazyState()
    }

    private fun form(user: IndividualPresenter,country: Country) = IndividualFields(user,country).toForm(
        heading = "Personal Form",
        details = "Update your personal information",
        config = config.toSubmitConfig()
    ) {
        onSubmit { output->
            output.toLater().then {
                output.toProfileParams().getOrThrow()
            }.andThen {
                config.api.profile.personal.update(it)
            }
        }
    }
}