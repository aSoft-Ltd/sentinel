package sentinel.internal

import sentinel.BusinessLogoScene
import sentinel.ChangePasswordScene
import sentinel.ProfileApiProvider
import sentinel.ProfileInfoScene
import sentinel.ProfilePictureScene
import sentinel.ProfileScenes
import sentinel.ProfileScenesConfig

@PublishedApi
internal class ProfileScenesImpl(config: ProfileScenesConfig<ProfileApiProvider>) : ProfileScenes {
    override val businessLogo by lazy { BusinessLogoScene(config) }
    override val profilePicture by lazy { ProfilePictureScene(config) }
    override val profileInfo by lazy { ProfileInfoScene(config) }
    override val profilePasswordChange by lazy { ChangePasswordScene(config) }
}