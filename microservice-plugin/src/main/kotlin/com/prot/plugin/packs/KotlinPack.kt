package com.prot.plugin.packs

import com.prot.plugin.implementation
import com.prot.plugin.plugins.CustomKotlinPlugin
import com.prot.plugin.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.plugin.DefaultKotlinBasePlugin

// https://docs.spring.io/spring-boot/docs/current/reference/html/dependency-versions.html#appendix.dependency-versions.coordinates
abstract class KotlinPack : GenericPack{
    abstract val kotlinVersion: Property<String>
    abstract val jvmTargetVersion: Property<String>
    abstract val coroutinesVersion: Property<String>
    abstract val kotestVersion: Property<String>
    abstract val detektVersion: Property<String>


    init {
        kotlinVersion.convention("1.7.22")
        jvmTargetVersion.convention("17")
        coroutinesVersion.convention("1.6.4")
        kotestVersion.convention("5.5.4")
        detektVersion.convention("1.22.0")
    }

    override fun addDeclaredDependencies(dh: DependencyHandler) {
        with(dh) {
            implementation(enforcedPlatform("org.jetbrains.kotlin:kotlin-bom:${kotlinVersion.get()}"))
            testImplementation(kotlin("test", version = kotlinVersion.get()))
        }
    }

    override fun getAllPlugins(): List<Class<out Plugin<Project>>> {
        return listOf(
            CustomKotlinPlugin::class.java
        )
    }
}