plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

kotlin {
    jvm { library() }
    js(IR) { library() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.sentinelEnterpriseAuthenticationApiCore)
                api(projects.pioneRest)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(projects.authenticatorApiRestPioneTest)
                implementation(projects.koncurrentLaterCoroutines)
                implementation(projects.authenticatorApiTest)
                implementation(projects.koncurrentLaterCoroutines)
                implementation(projects.picortexApiPione)
                implementation(projects.pioneTest)

            }
        }
    }
}