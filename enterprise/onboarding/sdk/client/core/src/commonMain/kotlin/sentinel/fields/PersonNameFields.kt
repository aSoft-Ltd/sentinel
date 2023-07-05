@file:JsExport
@file:Suppress("OPT_IN_USAGE", "NON_EXPORTABLE_TYPE")

package sentinel.fields

import neat.required
import symphony.Fields
import symphony.name
import kotlin.js.JsExport

class PersonNameFields(output: PersonNameOutput) : Fields<PersonNameOutput>(output) {
    val name = name(
        name = output::personName,
        label = "Your name",
        hint = "John Doe"
    ) { required() }
}