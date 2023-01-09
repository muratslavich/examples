plugins {
    id("microservice-plugin")
//    kotlin("jvm") version "1.7.22"
//    application
}

group = "com.prot.example"
version = "0.1.0"

repositories {
    mavenCentral()
}

microservice {
    kotlin {
        kotlinVersion.set("1.7.21")
    }
}

dependencies {
}

//sourceSets {
//    main {
//        kotlin.srcDir("src/main/kotlin")
//    }
//}

//task("prepareDirs") {
//    doLast {
//        mkdir( "${projectDir}/src/${sourceSets.main.name}/kotlin/${project.group.toString().replace('.', '/')}" )
//        mkdir( "${projectDir}/src/${sourceSets.test.name}/kotlin/${project.group.toString().replace('.', '/')}" )
//    }
//}
