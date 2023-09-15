@file:JsExport
@file:Suppress("OPT_IN_USAGE", "NON_EXPORTABLE_TYPE")

package sentinel.fields

import symphony.Fields
import symphony.text
import kotlin.js.JsExport

class AddressFields(output: AddressOutput) : Fields<AddressOutput>(output) {
    val address = text(
        name = output::address,
        label = "Business Address",
        hint = "4th Floor, 301 Sixth Street"
    )
}