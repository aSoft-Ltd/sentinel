package sentinel

import pione.ApiConfigRestKtor

interface AuthenticationApiPiOneConfig<E> : ApiConfigRestKtor<E> {
    val passwordResetUrl: String
}