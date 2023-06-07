plugins {
    kotlin("jvm") version "1.9.0-Beta"
    id("org.jetbrains.intellij") version "1.13.2"
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

dependencies{
    implementation("org.jetbrains:annotations:23.0.0")
}

val intellijVersion = System.getenv().getOrDefault("IDEA_VERSION", "PC-2023.1.2")

val pythonPluginForVersion = mapOf(
    "PC-2023.1.2" to "python-ce",
    "IC-2023.1" to "PythonCore:231.5744.248",
)

intellij {
    version.set(intellijVersion)
    plugins.set(listOf(pythonPluginForVersion[intellijVersion]))
}

java.sourceCompatibility = JavaVersion.VERSION_17

tasks.patchPluginXml {
    sinceBuild.set("222")
    untilBuild.set("999.*")
}
