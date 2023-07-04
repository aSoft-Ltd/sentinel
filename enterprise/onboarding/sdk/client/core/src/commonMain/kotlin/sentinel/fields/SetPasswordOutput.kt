package sentinel.fields

import identifier.params.PasswordParams

class SetPasswordOutput(
    var password1: String? = "",
    var password2: String? = ""
) {
    fun toParams(): PasswordParams {
        TODO()
    }
}