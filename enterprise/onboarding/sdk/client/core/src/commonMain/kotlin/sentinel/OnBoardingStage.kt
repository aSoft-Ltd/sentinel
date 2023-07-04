@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import sentinel.fields.AccountTypeFields
import sentinel.fields.BusinessNameFields
import sentinel.fields.CurrencyFields
import sentinel.fields.AddressFields
import sentinel.fields.PersonNameFields
import symphony.FormStage
import kotlin.js.JsExport

sealed class OnBoardingStage : FormStage {
    data class Account(
        override val heading: String,
        override val details: String,
        override val fields: AccountTypeFields
    ) : OnBoardingStage()

    data class PersonName(
        override val heading: String,
        override val details: String,
        override val fields: PersonNameFields
    ) : OnBoardingStage()

    data class BusinessName(
        override val heading: String,
        override val details: String,
        override val fields: BusinessNameFields
    ) : OnBoardingStage()

    data class Currency(
        override val heading: String,
        override val details: String,
        override val fields: CurrencyFields
    ) : OnBoardingStage()

    data class Address(
        override val heading: String,
        override val details: String,
        override val fields: AddressFields
    ) : OnBoardingStage()

    val asAccount get() = this as? Account
    val asPersonName get() = this as? PersonName
    val asBusinessName get() = this as? BusinessName
    val asCurrency get() = this as? Currency
    val asAddress get() = this as? Address
}