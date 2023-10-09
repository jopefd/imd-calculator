rootProject.name = "imd-calculator"

include(
    "modules:academic-calculator",
    "modules:android-application",
    "modules:simple-calculator"
)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
