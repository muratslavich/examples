plugins {
    kotlin("jvm") version "1.7.22"

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
}

dependencies {
    implementation(kotlin("stdlib"))
}
