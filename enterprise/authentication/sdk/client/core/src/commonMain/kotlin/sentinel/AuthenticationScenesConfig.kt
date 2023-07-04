package sentinel

import hormone.HasApi
import lexi.Logable

interface AuthenticationScenesConfig<out A> : HasApi<A>, Logable