plugins {
    kotlin("jvm") version "2.3.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.0.3")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.3") 
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}

sourceSets {
    main {
        kotlin.srcDirs(
            "src/kotlin/normal",
            "src/kotlin/advanced"  // Add advanced for coroutines
        )
    }
    test {
        kotlin.srcDirs("src/test/kotlin")
    }
}

application {
    mainClass.set("MainKt")  // Or whichever has main
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
