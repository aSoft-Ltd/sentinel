@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import cinematic.BaseScene
import identifier.CorporatePresenter
import identifier.params.CorporateParams
import identifier.params.IndividualProfileParams
import identifier.transformers.toPresenter
import kase.Result
import kase.bagOf
import koncurrent.Later
import koncurrent.later.finally
import neat.required
import sentinel.fields.AccountTypeFields
import sentinel.fields.AddressFields
import sentinel.fields.BusinessNameFields
import sentinel.fields.CurrencyFields
import sentinel.fields.PersonNameFields
import symphony.Visibility
import symphony.toForm
import symphony.toSubmitConfig
import kotlin.js.JsExport

class OnBoardingScene(config: OnboardingScenesConfig<ProfileApi>) : BaseScene() {

    private val output = OnBoardingOutput()

    val form = listOf(
        OnBoardingStage.Account(
            heading = "Choose your account type",
            details = "Are you an individual or business?",
            fields = AccountTypeFields(output)
        ),
        OnBoardingStage.PersonName(
            heading = "Enter your name",
            details = "Whats your name?",
            fields = PersonNameFields(output)
        ),
        OnBoardingStage.BusinessName(
            heading = "Enter the name of your business",
            details = "Whats the name of your business?",
            fields = BusinessNameFields(output.type, output)
        ),
        OnBoardingStage.Currency(
            heading = "Choose your default currency",
            details = "Which currency are you operating in?",
            fields = CurrencyFields(output)
        ),
        OnBoardingStage.Address(
            heading = "Enter your operating address",
            details = "Where are you operating from?",
            fields = AddressFields(output)
        )
    ).toForm(
        output = output,
        config = config.toSubmitConfig(),
        visibility = Visibility.Visible
    ) {
        onSubmit { completeOnBoarding() }
    }

    private val api = config.api

    private val completionHandler = bagOf<(Result<CorporatePresenter>) -> Unit>()
    fun initialize(onComplete: (Result<CorporatePresenter>) -> Unit) {
        completionHandler.value = onComplete
    }

    fun deInitialize() {
        completionHandler.clean()
    }

    private fun completeOnBoarding(): Later<Any> {
        val country = output::country.required
        val personName = output::personName.required
        val business = output.businessName ?: personName
        val address = output.address

        return Later(IndividualProfileParams(name=personName, location = address)).andThen {
            api.personal.update(it)
        }.andThen {
            api.organisation.updateCurrency(country.currency)
        }.then {
            CorporateParams(name = business, hqLocation = address)
        }.andThen {
            api.organisation.update(it)
        }.then {
            it.toPresenter()
        }.finally {
            completionHandler.value?.invoke(it)
        }
    }
}