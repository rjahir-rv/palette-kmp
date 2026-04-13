import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.android.multiplatform.library)
}

kotlin {

    android {
        compileSdk = 36
        namespace = "com.palette.kmp"
        compilerOptions {
            jvmTarget = JvmTarget.JVM_11 // Max supported version for Android
        }
        androidResources{
            enable = true
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "kmp"
            isStatic = true
        }
    }

    jvm {
        compilerOptions {
            jvmTarget = JvmTarget.JVM_25 // Current LTS
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.foundation)
            implementation(libs.compose.runtime)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
            implementation(libs.compose.navigation3.ui)
            implementation(libs.compose.components.resources)
            implementation(libs.compose.lifecycle.viewmodel)
            implementation(libs.compose.lifecycle.runtime)
            implementation(libs.ui.tooling.preview)
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs)
        }
        androidMain.dependencies {
            implementation(libs.ui.tooling.preview)
            implementation(libs.ui.tooling)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
