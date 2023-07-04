package sentinel

import geo.Country
import geo.GeoLocation
import sentinel.fields.AccountTypeOutput
import sentinel.fields.AddressOutput
import sentinel.fields.BusinessNameOutput
import sentinel.fields.CurrencyOutput
import sentinel.fields.PersonNameOutput

data class OnBoardingOutput(
    override var type: AccountType? = null,
    override var personName: String? = null,
    override var businessName: String? = null,
    override var country: Country? = null,
    override var address: GeoLocation? = null,
    var tax: Int? = null
) : AccountTypeOutput, PersonNameOutput, BusinessNameOutput, AddressOutput, CurrencyOutput