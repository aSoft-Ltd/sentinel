package sentinel.internal

import sentinel.AuthenticationApi
import sentinel.AuthenticationScenes
import sentinel.AuthenticationScenesConfig
import sentinel.BarrierScene
import sentinel.RegistrationScene
import sentinel.SignInScene

@PublishedApi
internal class AuthenticationScenesImpl(config: AuthenticationScenesConfig<AuthenticationApi>) : AuthenticationScenes {
    override val signIn by lazy { SignInScene(config) }
    override val barrier by lazy { BarrierScene(config) }
    override val registration by lazy { RegistrationScene(config) }
}