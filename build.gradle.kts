// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.randallpt.versionplugin.AndroidX
import com.randallpt.versionplugin.BuildConfig
import com.randallpt.versionplugin.Depend

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.madroid.palm2.app"
    compileSdk = BuildConfig.compileSdkVersion

    defaultConfig {
        minSdk = BuildConfig.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/INDEX.LIST" // Add this line
            excludes += "META-INF/DEPENDENCIES" // And this line
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(mapOf("path" to ":PT_Base_Lib:architecture")))

    implementation("io.grpc:grpc-okhttp:1.53.0")
    implementation("io.grpc:grpc-stub:1.54.0")
    implementation("io.grpc:grpc-protobuf:1.54.0")
    implementation("com.google.api:gax:2.26.0")
    implementation("com.google.api:gax-grpc:2.26.0")
    implementation("com.google.api:gax-grpc:2.26.0")

    implementation(AndroidX.activityCompose)
    implementation(AndroidX.lifecycleViewModelCompose)
    implementation(platform(AndroidX.composeBom))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    testImplementation(Depend.junit)
    androidTestImplementation(Depend.androidTestJunit)
    androidTestImplementation(Depend.espressoCore)
    androidTestImplementation(platform(AndroidX.composeBom))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}