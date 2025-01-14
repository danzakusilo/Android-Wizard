package wizard.files

import wizard.ProjectFile

class GradleProperties : ProjectFile {
    override val path = "gradle.properties"
    override val content = """
#Gradle
org.gradle.jvmargs=-Xmx2048M -Dfile.encoding=UTF-8 -Dkotlin.daemon.jvm.options\="-Xmx2048M"
org.gradle.caching=true
org.gradle.configuration-cache=true

#Kotlin
kotlin.code.style=official
kotlin.js.compiler=ir

#Compose
org.jetbrains.compose.experimental.uikit.enabled=true
org.jetbrains.compose.experimental.jscanvas.enabled=true

#Android
android.useAndroidX=true
android.nonTransitiveRClass=true
"""
}