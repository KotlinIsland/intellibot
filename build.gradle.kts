plugins {
    java
    id("org.jetbrains.intellij") version "1.6.0"
}

repositories {
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains:annotations:23.0.0")
}

val intellijVersion = System.getenv().getOrDefault("IDEA_VERSION", "PC-2022.1")

val pythonPluginForVersion = mapOf(
    "PC-2022.1" to "python-ce",
    "IC-2022.1" to "PythonCore:221.5744.248",
)

intellij {
    version.set(intellijVersion)
    plugins.set(listOf(pythonPluginForVersion[intellijVersion]))
}

java.sourceCompatibility = JavaVersion.VERSION_11

tasks.patchPluginXml {
    untilBuild.set("999.*")
}