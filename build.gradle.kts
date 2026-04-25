plugins {
    kotlin("jvm") version "2.3.20"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

// ⭐ THÊM PHẦN NÀY để Gradle tìm đúng recipe
sourceSets {
    main {
        kotlin.srcDirs("src/kotlin/normal")
    }
    test {
        kotlin.srcDirs("src/test/kotlin")  // ← SỬA LẠI: không phải "src/kotlin/test"
    }
}

tasks.test {
    useJUnitPlatform()
}

