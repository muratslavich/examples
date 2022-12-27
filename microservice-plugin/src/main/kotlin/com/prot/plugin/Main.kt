package com.prot.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class Main : Plugin<Project> {

    override fun apply(project: Project) {
        project.task("hello") {
            it.doLast {
                println("Hello from the GreetingPlugin")
            }
        }
    }

}