package com.prot.plugin

import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

class Main : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create<MicroservicePluginExtension>("microservice")

        project.task("hello") {
            doLast {
                println("Hello from the ${extension.kotlin.isInitialized()}")
            }
        }
    }

}

open class MicroservicePluginExtension(project: Project) {

    private val objects by lazy { project.objects }
    val kotlin: Lazy<KotlinPack> = lazyInstance()
    val spring: Lazy<SpringPack> = lazyInstance()
    val springBoot: Lazy<SpringBootPack> = lazyInstance()

    fun kotlin(action: Action<KotlinPack>) {
        action.execute(kotlin.value)
    }

    fun spring(action: Action<SpringPack>) {
        action.execute(spring.value)
    }

    fun springBoot(action: Action<SpringBootPack>) {
        action.execute(springBoot.value)
    }

    private inline fun <reified T> lazyInstance(): Lazy<T> {
        return lazy { objects.newInstance(T::class.java) }
    }
}

interface SpringPack {

}

interface SpringBootPack {

}

interface KotlinPack{
    val kotlinVersion: Property<String>
    val jvmTargetVersion: Property<String>
    val coroutinesVersion: Property<String>
    val kotestVersion: Property<String>
    val detektVersion: Property<String>
}
