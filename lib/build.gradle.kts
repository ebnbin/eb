plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    `maven-publish`
}

android {
    val versionMap: Map<String, String> by rootProject.extra
    compileSdkVersion(versionMap.getValue("compileSdkVersion").toInt())
    defaultConfig {
        minSdkVersion(versionMap.getValue("minSdkVersion").toInt())
        targetSdkVersion(versionMap.getValue("targetSdkVersion").toInt())
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val dependencyMap: Map<String, String> by rootProject.extra
    fun dependency(id: String): String {
        val version = dependencyMap[id].also {
            requireNotNull(it)
        }
        return "$id:$version"
    }
    api(dependency("androidx.core:core-ktx"))
    api(dependency("androidx.recyclerview:recyclerview"))
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
            }
        }
    }
}
