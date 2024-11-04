import org.gradle.internal.os.OperatingSystem

plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    id("java")
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
}

group = "teampixl.com"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

/* FORCE DELETE BUILD DIR -- GOOD TO PREVENT BUILD ISSUES WITH CLOUD */
//tasks.register<Exec>("deleteBuildDir") {
//    val os = OperatingSystem.current()
//    val buildDirPath = layout.buildDirectory.get().asFile.absolutePath
//
//    if (os.isWindows) {
//        commandLine("cmd", "/c", "rmdir", "/s", "/q", "\"$buildDirPath\"")
//    } else {
//        commandLine("rm", "-rf", buildDirPath)
//    }
//}
//
//tasks.named("compileKotlin") {
//    dependsOn("deleteBuildDir")
//}
//
//tasks.named("compileJava") {
//    dependsOn("deleteBuildDir")
//}


