buildscript {
    apply("https://raw.githubusercontent.com/ebnbin/gradle-extra/v0.0.1/extra.gradle.kts")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        val dependencyMap: Map<String, String> by rootProject.extra
        fun dependency(id: String): String {
            val version = dependencyMap[id].also {
                requireNotNull(it)
            }
            return "$id:$version"
        }
        classpath(dependency("com.android.tools.build:gradle"))
        classpath(dependency("org.jetbrains.kotlin:kotlin-gradle-plugin"))
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
