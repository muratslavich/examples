package com.prot.plugin.packs

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler

abstract class SpringBootPack : GenericPack {

    override fun getAllPlugins(): List<Class<out Plugin<Project>>> {
        return emptyList()
    }

    override fun addDeclaredDependencies(dh: DependencyHandler) {
        TODO("Not yet implemented")
    }

}