package wizard.files.rawAndroid

import wizard.ProjectFile
import wizard.ProjectInfo
import wizard.catalogAccessor

class AppGradle(info: ProjectInfo): ProjectFile {
    override val path: String
        get() = "app/build.gradle.kts"
    override val content = buildString {
        appendLine("import BuildPlugins.android")
        appendLine("""
            plugins {
                id("com.android.application")
                id("kotlin-android")
                kotlin("kapt")
                id("dagger.hilt.android.plugin")
            }
        """.trimIndent())
        // start android section
        appendLine("""
            android {
            compileSdk = ConfigInfo.compileSdkVersion
            buildToolsVersion = ConfigInfo.buildToolsVersion
            """.trimIndent())

        appendLine("""
            defaultConfig {
                apllicationId = "${info.packageId}.${info.name.replace(" ", "").lowercase()}"
                minSdk = ConfigInfo.minSdkVersion
                targetSdk = ConfigInfo.targetSdkVersion
                versionCode = ConfigInfo.versionCode
                versionName = ConfigInfo.versionName
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
        """.trimIndent())

        appendLine("""
            kapt {
                correctErrorTypes = true
            }
        """.trimIndent())

        appendLine("""
                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
        """.trimIndent())

        appendLine("""
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
        """.trimIndent())

        appendLine("""
                kotlinOptions {
                    jvmTarget = "1.8"
                }
        """.trimIndent())

        appendLine("""
                buildFeatures {
                    compose = true
                }
        """.trimIndent())

        appendLine("""
                composeOptions {
                    kotlinCompilerExtensionVersion = Versions.COMPOSE
                }
        """.trimIndent())

        appendLine("""
                packagingOptions {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }
        """.trimIndent())

        //end android section
        appendLine("\n}")

        appendLine("""dependencies {""")
        info.dependencies.forEach {
            appendLine("implementraion(Deps.${it.catalogAccessor})")
        }
        appendLine("}")
    }
}