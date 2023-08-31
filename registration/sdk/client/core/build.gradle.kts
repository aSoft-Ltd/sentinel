plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
}

description = "A kotlin multiplatform sdk registration"

kotlin {
    jvm { library() }
    js(IR) { library() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(projects.sentinelRegistrationApiCore)
                api(projects.sentinelReceptionSdkClientCore)
                api(libs.cinematic.scene.core)
                api(projects.hormoneCore)
                api(projects.keepApi)
                api(projects.symphonyInputIdentifier)
            }
        }

        val commonTest by getting {
            dependencies {
                api(libs.cinematic.live.test)
                api(libs.kommander.coroutines)
            }
        }
    }
}