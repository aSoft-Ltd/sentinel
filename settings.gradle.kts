pluginManagement {
    enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencyResolutionManagement {
        versionCatalogs {
            File(rootDir.parentFile, "versions/gradle/versions").listFiles().map {
                it.nameWithoutExtension to it.absolutePath
            }.forEach { (name, path) ->
                create(name) { from(files(path)) }
            }
        }
    }
}

fun includeRoot(name: String, path: String) {
    include(":$name")
    project(":$name").projectDir = File(path)
}

fun includeSubs(base: String, path: String = base, vararg subs: String) {
    subs.forEach {
        include(":$base-$it")
        project(":$base-$it").projectDir = File("$path/$it")
    }
}

rootProject.name = "sentinel"

includeBuild("../able")
// dependencies
includeSubs("functions", "../functions", "core")
includeSubs("kommander", "../kommander", "core", "coroutines")
includeSubs("kollections", "../kollections", "interoperable", "atomic")
includeSubs("koncurrent-executors", "../koncurrent/executors", "core", "coroutines", "mock")
includeSubs("koncurrent-later", "../koncurrent/later", "api", "core", "coroutines", "test")
includeSubs("kevlar", "../kevlar", "api", "core")
includeSubs("kase", "../kase", "core")
includeSubs("cinematic-live", "../cinematic/live", "core", "kollections", "coroutines", "test", "compose")
includeSubs("krono", "../krono", "api", "kotlinx")