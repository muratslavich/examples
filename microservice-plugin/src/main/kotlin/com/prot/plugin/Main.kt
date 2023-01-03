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
                println("Hello from the ${extension.kotlin.kotlinVersion.get()}")
            }
        }
    }

}



open class MicroservicePluginExtension(project: Project) {
    private val objects = project.objects

    val kotlin: KotlinPack = objects.newInstance(KotlinPack::class.java)
    val spring: SpringPack = objects.newInstance(SpringPack::class.java)
    val springBoot: SpringBootPack = objects.newInstance(SpringBootPack::class.java)

    fun kotlin(action: Action<KotlinPack>) {
        action.execute(kotlin)
    }

    fun spring(action: Action<SpringPack>) {
        action.execute(spring)
    }

    fun springBoot(action: Action<SpringBootPack>) {
        action.execute(springBoot)
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
