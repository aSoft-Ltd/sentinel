@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package sentinel

import kotlin.js.JsExport

interface ProfileScenes {
    val businessLogo: BusinessLogoScene
    val profilePicture: ProfilePictureScene
    val profilePasswordChange: ChangePasswordScene
    val profileInfo: ProfileInfoScene
}