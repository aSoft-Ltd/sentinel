package sentinel

import identifier.OrganisationProfileApi
import identifier.PersonalProfileApi

interface ProfileApi {
    val personal: PersonalProfileApi
    val organisation: OrganisationProfileApi
}