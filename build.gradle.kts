plugins {
    java
    id("org.jetbrains.intellij") version "1.3.0"
}

repositories {
    mavenCentral()
}

dependencies{
    implementation("org.jetbrains:annotations:22.0.0")
}

val intellijVersion = System.getenv().getOrDefault("IDEA_VERSION", "PC-2021.3")

val pythonPluginForVersion = mapOf(
    "PC-2021.3" to "python-ce",
    "IC-2021.3" to "PythonCore:213.5744.248",
)

intellij {
    version.set(intellijVersion)
    plugins.set(listOf(pythonPluginForVersion[intellijVersion]))
}

java.sourceCompatibility = JavaVersion.VERSION_11
