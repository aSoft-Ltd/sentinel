import java.io.File

pluginManagement {
    includeBuild("../build-logic")
}

plugins {
    id("multimodule")
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

listOf(
    "cinematic", "keep", "lexi", "captain", "neat", "kash", "geo", "kase",
    "kronecker", "symphony", "epsilon-api", "epsilon-client", "krono", "hormone", "identifier",
    "kommerce", "kollections", "koncurrent", "kommander", "cabinet-api", "cabinet-picortex", "pione", "snitch"
).forEach { includeBuild("../$it") }

rootProject.name = "sentinel"

includeSubs(base = "sentinel-reception-api", path = "../sentinel/reception/api", "core")
includeSubs(base = "sentinel-reception-sdk-client", path = "../sentinel/reception/sdk/client", "core")
includeSubs(base = "sentinel-registration-api", path = "../sentinel/registration/api", "core", "pione")
includeSubs(base = "sentinel-registration-sdk-client", path = "../sentinel/registration/sdk/client", "core")
includeSubs(base = "sentinel-enterprise-authentication-api", path = "../sentinel/enterprise/authentication/api", "core", "pione")
includeSubs(base = "sentinel-enterprise-authentication-sdk-client", path = "../sentinel/enterprise/authentication/sdk/client", "core")
includeSubs(base = "sentinel-enterprise-profile-api", path = "../sentinel/enterprise/profile/api", "core", "pione")
includeSubs(base = "sentinel-enterprise-profile-sdk-client", path = "../sentinel/enterprise/profile/sdk/client", "core")
includeSubs(base = "sentinel-enterprise-onboarding-sdk-client", path = "../sentinel/enterprise/onboarding/sdk/client", "core")
