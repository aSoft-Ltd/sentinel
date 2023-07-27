package sentinel.transformers

import identifier.fields.IndividualOutput
import identifier.params.IndividualProfileParams

fun IndividualOutput.toProfileParams() = IndividualProfileParams(
    name = name ?: throw IllegalArgumentException("Name must not be null"),
    title = title,
    dob = dob,
    gender = gender,
    idDocumentNumber = idNumber,
    idDocumentType = idType,
    location = location,
)