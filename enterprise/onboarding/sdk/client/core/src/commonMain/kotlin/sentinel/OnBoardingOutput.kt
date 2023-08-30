package sentinel

import geo.Country
import geo.GeoLocation
import identifier.params.CorporateParams
import kase.catching
import neat.required
import sentinel.fields.AccountTypeOutput
import sentinel.fields.AddressOutput
import sentinel.fields.LocationOutput
import sentinel.fields.BusinessNameOutput
import sentinel.fields.CurrencyOutput

data class OnBoardingOutput(
    override var type: AccountType? = null,
    override var businessName: String? = null,
    override var country: Country? = null,
    override var location: GeoLocation? = null,
    override var address: String? = null,
    var tax: Int? = null
) : AccountTypeOutput, BusinessNameOutput, AddressOutput, LocationOutput, CurrencyOutput {
    fun toParams() = catching {
        CorporateParams(
            name = this::businessName.required,
            hqLocation = location,
            address = address
        )
    }

    fun toCurrency() = catching { this::country.required.currency }
}