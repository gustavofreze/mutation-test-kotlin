import info.solidsoft.gradle.pitest.PitestPluginExtension
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

group = "org.example"
version = "1.0.0"

plugins {
    id("jacoco")
    id("info.solidsoft.pitest") version "1.5.1"
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
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
        events = setOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        exceptionFormat = TestExceptionFormat.FULL
        showStandardStreams = true
    }
}

tasks {
    jacocoTestReport {
        reports {
            xml.isEnabled = false
            csv.isEnabled = false
            html.isEnabled = true
            html.destination = layout.buildDirectory.dir("jacocoHtml").get().asFile
        }
    }
}

plugins.withId("info.solidsoft.pitest") {
    configure<PitestPluginExtension> {
        verbose.set(false)
        testPlugin.set("junit5")
        outputFormats.set(setOf("HTML"))
    }
}