plugins {
    kotlin("multiplatform").version("1.9.20")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    js {
        browser {
            testTask {
                enabled = false
            }
        }
        binaries.executable()
    }
    sourceSets {
        jsMain.dependencies {
            implementation(enforcedPlatform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.605"))
            implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-mui")
            implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-icons")

            implementation(npm("file-saver", "2.0.5"))
            implementation(npm("jszip", "3.10.1"))
            implementation(npm("stream", "0.0.2"))
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}

task<Copy>("fixMissingJvmResources") {
    dependsOn("jvmProcessResources")
    tasks.findByPath("jvmTest")?.dependsOn(this)

    from("$buildDir/processedResources/jvm/main")
    into("$buildDir/resources/")
}
