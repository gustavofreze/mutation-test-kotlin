import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    id("jacoco")
    id("info.solidsoft.pitest") version ("1.5.1")
    id("org.jetbrains.kotlin.jvm") version ("1.4.32")
}

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")

    pitest("org.pitest:pitest-junit5-plugin:0.12")
}

tasks.jacocoTestReport {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.isEnabled = true
        html.destination = layout.buildDirectory.dir("jacocoHtml").get().asFile
    }
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
            exceptionFormat = TestExceptionFormat.FULL
            showStandardStreams = true
        }
    }
}

plugins.withId("info.solidsoft.pitest") {
    configure<info.solidsoft.gradle.pitest.PitestPluginExtension> {
        verbose.set(false)
        testPlugin.set("junit5")
        outputFormats.set(setOf("HTML"))
    }
}