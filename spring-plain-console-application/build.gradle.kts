plugins {
    id("microservice-plugin")
}

group = "com.prot.example"
version = "0.1.0"

repositories {
    mavenCentral()
}

microservice {
    spring {
        springVersion.set("6.0.3")
    }
}
