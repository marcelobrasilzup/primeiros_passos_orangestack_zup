pluginManagement {
    val artifactoryUrl: String by settings

    repositories {
        mavenLocal()
        gradlePluginPortal()
        maven {
            url = uri(artifactoryUrl)
        }
    }
}
rootProject.name="domainservices-back-kotlin-rest-app"
