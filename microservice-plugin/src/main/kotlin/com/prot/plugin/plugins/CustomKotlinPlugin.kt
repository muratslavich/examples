package com.prot.plugin.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        println("tyest")
    }
}