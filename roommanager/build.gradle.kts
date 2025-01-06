/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    alias(libs.plugins.org.jetbrains.kotlin.jvm)
    alias(libs.plugins.org.jetbrains.dokka)
    application
}

dependencies {
    api(libs.com.google.code.gson.gson)
    api(libs.org.jetbrains.kotlin.kotlin.stdlib)
    api(libs.org.jetbrains.kotlinx.kotlinx.coroutines.core)
    api(libs.io.github.cdimascio.dotenv.kotlin)
    api(libs.io.ktor.ktor.client.core.jvm)

}
application {
    mainClass.set("dev.cyrilk.ApplicationKt")
}

dokka {
     dokkaPublications.html {
         outputDirectory.set(rootProject.layout.projectDirectory.dir("docs/public/kdoc"))
     }
        moduleName.set("Room Manager")
        dokkaSourceSets.main {

            sourceLink {
                localDirectory.set(file("src/main/kotlin"))
                remoteUrl("https://github.com/Gr1ll/kotlin")
            }
        }
}