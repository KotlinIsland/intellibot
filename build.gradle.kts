fun properties(key: String) = providers.gradleProperty(key)
fun environment(key: String) = providers.environmentVariable(key)

plugins {
    kotlin("jvm") version "1.9.22"
    id("org.jetbrains.intellij") version "1.17.1"
}

group = properties("pluginGroup").get()
version = properties("pluginVersion").get()

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        languageVersion = JavaLanguageVersion.of(17)
        @Suppress("UnstableApiUsage")
        vendor = JvmVendorSpec.JETBRAINS
    }
}

dependencies{
    implementation("org.jetbrains:annotations:23.0.0")
}

// Configure Gradle IntelliJ Plugin - read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    pluginName = properties("pluginName")
    version = properties("platformVersion")
    type = properties("platformType")

    // Plugin Dependencies. Uses `platformPlugins` property from the gradle.properties file.
    plugins = properties("platformPlugins").map { it.split(',').map(String::trim).filter(String::isNotEmpty) }
}

java.sourceCompatibility = JavaVersion.VERSION_17

tasks {
    wrapper {
        gradleVersion = properties("gradleVersion").get()
    }
}
