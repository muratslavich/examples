package com.prot.plugin.plugins

import com.prot.plugin.detektExtension
import com.prot.plugin.microserviceExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinBasePlugin

class CustomKotlinPlugin : Plugin<Project> {
    override fun apply(target: Project): Unit = target.run {
        val kotlin = microserviceExtension.getKotlin()

        kotlinExtension.jvmToolchain {
            languageVersion.set(JavaLanguageVersion.of(kotlin.jvmTargetVersion.get()))
        }

        detektExtension.apply {
            toolVersion = kotlin.detektVersion.get()
            ignoreFailures = true
            autoCorrect = false
        }

        plugins.withType<KotlinBasePlugin> {
            mkdir( "${projectDir}/src/main/kotlin/${project.group.toString().replace('.', '/')}" )
            mkdir( "${projectDir}/src/test/kotlin/${project.group.toString().replace('.', '/')}" )
        }

    }
}