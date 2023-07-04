@file:JsExport
@file:Suppress("OPT_IN_USAGE", "NON_EXPORTABLE_TYPE")

package sentinel.fields

import geo.Country
import neat.required
import symphony.Fields
import symphony.Option
import symphony.selectSingle
import kotlin.js.JsExport

class CurrencyFields(output: CurrencyOutput) : Fields<CurrencyOutput>(output) {
    val currency = selectSingle(
        name = output::country,
        items = Country.values().toList(),
        mapper = { Option(it.currency.name) }
    ) { required() }
}