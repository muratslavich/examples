plugins {
    id("microservice-plugin")
}

group = "com.prot.example"
version = "0.1.0"

repositories {
    mavenCentral()
}

microservice {
    kotlin {
        kotlinVersion.set("1.7.21")
        jvmTargetVersion.set("17")
        coroutinesVersion.set("1.6.4")
    }
    springBoot {
        springBootVersion.set("")
    }
}
