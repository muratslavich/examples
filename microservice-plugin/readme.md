## Resolve custom plugins
- Including the plugin from the plugin portal or a custom repository using the plugins DSL (see Applying plugins using the plugins DSL).
- Including the plugin from an external jar defined as a buildscript dependency (see Applying plugins using the buildscript block).
- Defining the plugin as a source file under the buildSrc directory in the project (see Using buildSrc to extract functional logic).
- Defining the plugin as an inline class declaration inside a build script.

## Use local plugins m2 repository
Before you can publish your plugin code to mavenLocal(), you have to add add the ‘maven-publish’ to your plugin build.gradle.
```
plugins {
    id 'java-gradle-plugin'
    id 'maven-publish'
}
```

Then publish you artifacts to mavenLocal()
`$ gradlew publishToMavenLocal` 

In your application code add mavenLocal() to the pluginManagement of your settings.gradle file.
```
pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }
}
```

Now you can reach your plugin in your application build.gradle from maven local repository :)
```
plugins {
    id '<myplugin-id>' version '<myplugin-version>'
}
```







https://gradle-initializr.cleverapps.io/
