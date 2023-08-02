package sentinel

import hormone.HasApi
import lexi.Logable
import keep.Cacheable

interface AuthenticationScenesConfig<out A> : HasApi<A>, Logable, Cacheable