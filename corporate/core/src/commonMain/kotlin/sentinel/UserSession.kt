@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import identifier.Corporate
import identifier.Individual
import kash.Currency
import kotlinx.serialization.Serializable
import kotlin.js.JsExport

@Serializable
data class UserSession(
    val user: Individual,
    val secret: String,
    val company: Corporate,
    val currency: Currency,
    val timezone: String,
    val salesTax: Int
)