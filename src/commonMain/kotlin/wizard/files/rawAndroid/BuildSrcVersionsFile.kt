package wizard.files.rawAndroid

import wizard.ProjectFile
import wizard.ProjectInfo

class BuildSrcVersionsFile(info: ProjectInfo): ProjectFile {
    override val path: String
        get() = "buildSrc/src/main/kotlin/Versions.kt"
    override val content =
         buildString {
            appendLine("object Versions {")
            info.dependencies
                .forEach {
                    appendLine("    const val ${it.catalogVersionName.uppercase()} = ${it.version}")
                }
            appendLine("}")
        }
}