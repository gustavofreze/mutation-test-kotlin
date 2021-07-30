import info.solidsoft.gradle.pitest.PitestPluginExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
import org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
import org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED

group = "org.example"
version = "1.0.0"

plugins {
    id("info.solidsoft.pitest") version "1.5.1"
    id("org.jetbrains.kotlin.jvm") version "1.5.21"
}

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")

    pitest("org.pitest:pitest-junit5-plugin:0.12")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events = setOf(FAILED, PASSED, SKIPPED)
        exceptionFormat = FULL
        showStandardStreams = true
    }
}

plugins.withId("info.solidsoft.pitest") {
    configure<PitestPluginExtension> {
        verbose.set(false)
        testPlugin.set("junit5")
        outputFormats.set(setOf("HTML"))
    }
}