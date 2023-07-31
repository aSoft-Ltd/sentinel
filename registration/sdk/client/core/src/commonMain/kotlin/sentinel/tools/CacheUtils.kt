@file:Suppress("NOTHING_TO_INLINE")

package sentinel.tools

import keep.Cache
import sentinel.params.SignUpParams
import sentinel.params.VerificationParams

@PublishedApi
internal const val KEY_SIGN_UP_PARAMS = "sentinel.registration.sign.up.params"

@PublishedApi
internal const val KEY_VERIFICATION_PARAMS = "sentinel.registration.verification.params"

// --------------------------Sign Up Params --------------------------
inline fun Cache.save(params: SignUpParams) = save(KEY_SIGN_UP_PARAMS, params, SignUpParams.serializer())

inline fun Cache.loadSignUpParams() = load(KEY_SIGN_UP_PARAMS, SignUpParams.serializer())


// -------------------------- Verification Params ---------------------
inline fun Cache.save(params: VerificationParams) = save(KEY_VERIFICATION_PARAMS, params, VerificationParams.serializer())

inline fun Cache.loadVerificationParams() = load(KEY_VERIFICATION_PARAMS, VerificationParams.serializer())

inline fun Cache.removeVerificationParams() = remove(KEY_VERIFICATION_PARAMS)