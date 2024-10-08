/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.8/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // jar fattener
    id("com.gradleup.shadow") version "8.3.0"
    // Apply the application plugin to add support for building a CLI application in Java.

    java

    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

    //implementation("com.gradleup.shadow:com.gradleup.shadow.gradle.plugin:8.3.0")

    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)

    // LaTeX rendering library
    implementation("org.scilab.forge:jlatexmath:1.0.7")

    // Expression parser
    implementation("net.objecthunter:exp4j:0.4.8")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass.set("net.coosanta.calculator.Main")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}

//// Configure the shadowJar task
//tasks {
//    shadowJar {
//        archiveClassifier.set("")
//        manifest {
//            attributes["Main-Class"] = application.mainClass.get()
//        }
//    }
//}

//// Ensure the shadowJar task is used when building the jar
//// Ensure the clean task is executed before building the shadow JAR
//tasks.build {
//    dependsOn(tasks.shadowJar)
//}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

// Update Gradle to use non-deprecated features
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.release.set(21)
}
