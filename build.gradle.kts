plugins {
    kotlin("jvm") version "1.9.10"
    kotlin("plugin.serialization") version "1.9.10"
    id("io.ktor.plugin") version "2.3.3"
    id("org.jetbrains.compose") version "1.5.1"
}

group = "dev.marxx"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev")
    maven("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    
    // Ktor Server
    implementation("io.ktor:ktor-server-core:2.3.3")
    implementation("io.ktor:ktor-server-netty:2.3.3")
    implementation("io.ktor:ktor-server-auth:2.3.3")
    implementation("io.ktor:ktor-server-auth-jwt:2.3.3")
    implementation("io.ktor:ktor-server-cors:2.3.3")
    implementation("io.ktor:ktor-server-content-negotiation:2.3.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")
    
    // Logging
    implementation("io.ktor:ktor-server-call-logging:2.3.3")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    
    // Compose for Web (multiplatform)
    implementation("org.jetbrains.compose.web:web-core:1.5.1")
    implementation("org.jetbrains.compose.web:web-widgets:1.5.1")
    
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    
    // Testing
    testImplementation("io.ktor:ktor-server-tests:2.3.3")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.10")
    testImplementation("junit:junit:4.13.2")
}

kotlin {
    jvmToolchain(17)
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.named("build"))
}
