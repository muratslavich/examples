plugins {
    // https://plugins.gradle.org/plugin/org.gradle.kotlin.kotlin-dsl
    `kotlin-dsl`

    // https://plugins.gradle.org/docs/publish-plugin
    // Auto-apply `java-gradle-plugin` plugin
    // Auto-apply `maven-publish` plugin
    id("com.gradle.plugin-publish") version "1.1.0"
}

group = "com.prot.plugin"
version = "0.1.0"

gradlePlugin {
    website.set("https://github.com/gradleTest")
    vcsUrl.set("https://github.com/gradleTest.git")
    plugins {
        create("microservicePlugin") {
            id = "microservice-plugin"
            displayName = "Plugin for build microservices in prot project"
            description = "Cool plugin"
            implementationClass = "com.prot.plugin.Main"
        }
    }
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    api(kotlin("stdlib"))
    api("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    api("org.jetbrains.kotlin:kotlin-allopen:1.8.0")
    api("org.jetbrains.kotlin:kotlin-noarg:1.8.0")
    api("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:1.22.0")
    api("org.springframework.boot:spring-boot-gradle-plugin:3.0.1")
    api("io.spring.gradle:dependency-management-plugin:1.1.0")
}
