plugins {
    java
    id("org.jetbrains.intellij") version "0.7.2"
}

repositories {
    mavenCentral()
}

dependencies{
    compileOnly("org.jetbrains:annotations:20.1.0")
}

val intellijVersion = System.getenv().getOrDefault("IDEA_VERSION", "PC-2021.2")

val pythonPluginForVersion = mapOf(
    "PC-2021.2" to "python-ce",
    "IC-2021.2" to "PythonCore:212.5080.64",
)

intellij {
    version = intellijVersion
    setPlugins(pythonPluginForVersion[intellijVersion])
}

java.sourceCompatibility = JavaVersion.VERSION_11
