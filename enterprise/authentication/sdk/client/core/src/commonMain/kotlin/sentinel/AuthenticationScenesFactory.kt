@file:Suppress("NOTHING_TO_INLINE")

package sentinel

import sentinel.internal.AuthenticationScenesImpl

inline fun AuthenticationScenes(config: AuthenticationScenesConfig<AuthenticationApi>) : AuthenticationScenes = AuthenticationScenesImpl(config)