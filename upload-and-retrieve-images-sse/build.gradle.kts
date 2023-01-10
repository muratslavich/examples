plugins {
    id("microservice-plugin")
    kotlin("plugin.spring") version "1.8.0"
}

group = "com.prot.example"
version = "0.1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

microservice {
    springBoot {}
    kotlin {}
}