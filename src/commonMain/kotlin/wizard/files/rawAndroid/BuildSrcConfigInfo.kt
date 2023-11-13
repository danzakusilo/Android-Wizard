package wizard.files.rawAndroid

import wizard.ProjectFile

class BuildSrcConfigInfo(): ProjectFile {
    override val path: String
        get() = "buildSrc/src/main/kotlin/ConfigInfo.kt"
    override val content = """object ConfigInfo {
    const val compileSdkVersion = 34
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 24
    const val targetSdkVersion = 34
    const val versionCode = 1
    const val versionName = "1.0"
}"""
}
