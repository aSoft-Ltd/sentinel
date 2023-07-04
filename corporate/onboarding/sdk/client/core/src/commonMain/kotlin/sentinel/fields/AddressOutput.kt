package sentinel.fields

import geo.GeoLocation

interface AddressOutput {
    var address: GeoLocation?
}