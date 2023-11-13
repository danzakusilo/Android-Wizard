package wizard.files.rawAndroid

import wizard.ProjectFile
import wizard.ProjectInfo

class BuildSrcDepsFile(info: ProjectInfo): ProjectFile{
    override val path: String
        get() = "buildSrc/src/main/kotlin/Dependencies.kt"
    override val content = buildString {
        appendLine("object Dependencies {")
        info.dependencies.forEach {
            val versionNameReference = it.catalogVersionName.uppercase()
            appendLine(
                "   val ${it.catalogName} by lazy { \"\${Versions.${versionNameReference}}}"
            )
        }
        appendLine("}")
    }
}