@file:JsExport
@file:Suppress("OPT_IN_USAGE", "NON_EXPORTABLE_TYPE")

package sentinel.fields

import symphony.Fields
import symphony.location
import kotlin.js.JsExport

class LocationFields(output: LocationOutput) : Fields<LocationOutput>(output) {
    val location = location(name = output::location)
}