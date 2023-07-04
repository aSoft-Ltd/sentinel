@file:JsExport
@file:Suppress("OPT_IN_USAGE", "NON_EXPORTABLE_TYPE")

package sentinel.fields

import symphony.Fields
import symphony.location
import kotlin.js.JsExport

class AddressFields(output: AddressOutput) : Fields<AddressOutput>(output) {
    val address = location(name = output::address)
}