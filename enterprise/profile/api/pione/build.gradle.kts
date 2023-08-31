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
                api(projects.sentinelEnterpriseProfileApiCore)
                api(projects.pioneRest)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.koncurrent.later.coroutines)
            }
        }
    }
}