package com.prot.plugin

import com.prot.plugin.packs.KotlinPack
import com.prot.plugin.packs.SpringBootPack
import com.prot.plugin.packs.SpringPack
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginManager

open class MicroservicePluginExtension(val project: Project) {

    private val objects by lazy { project.objects }
    private val kotlin: Lazy<KotlinPack> = lazyInstance()
    private val spring: Lazy<SpringPack> = lazyInstance()
    private val springBoot: Lazy<SpringBootPack> = lazyInstance()
    private val container = listOf(kotlin, spring, springBoot)

    fun kotlin(action: Action<KotlinPack>) = action.execute(kotlin.value)
    fun spring(action: Action<SpringPack>) = action.execute(spring.value)
    fun springBoot(action: Action<SpringBootPack>) = action.execute(springBoot.value)

    fun deps(dependencies: DependencyHandler) {
        container.forEach {
            if (it.isInitialized()) it.value.addDeclaredDependencies(dependencies)
        }
    }

    fun plugins(pluginManager: PluginManager) {
        container.forEach {
            if (it.isInitialized()) {
                it.value.getAllPlugins().forEach { plugin -> pluginManager.apply(plugin) }
            }
        }
    }

    private inline fun <reified T> lazyInstance() = lazy { objects.newInstance(T::class.java) }
}

fun DependencyHandler.`implementation`(dependencyNotation: Any): Dependency =
    add("implementation", dependencyNotation)!!

fun DependencyHandler.`testImplementation`(dependencyNotation: Any): Dependency =
    add("testImplementation", dependencyNotation)!!

fun DependencyHandler.`testRuntimeOnly`(dependencyNotation: Any): Dependency =
    add("testRuntimeOnly", dependencyNotation)!!

fun DependencyHandler.`compileOnly`(dependencyNotation: Any): Dependency =
    add("compileOnly", dependencyNotation)!!

fun DependencyHandler.`annotationProcessor`(dependencyNotation: Any): Dependency =
    add("annotationProcessor", dependencyNotation)!!

fun DependencyHandler.`testCompileOnly`(dependencyNotation: Any): Dependency =
    add("testCompileOnly", dependencyNotation)!!

fun DependencyHandler.`testAnnotationProcessor`(dependencyNotation: Any): Dependency =
    add("testAnnotationProcessor", dependencyNotation)!!

