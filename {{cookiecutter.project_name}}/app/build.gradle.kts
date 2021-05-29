plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(30)
        applicationId = "{{cookiecutter.package_name}}.sample"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        isCheckReleaseBuilds = false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        isAbortOnError = false
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

dependencies {
    api("org.jetbrains.kotlin:kotlin-stdlib:{{cookiecutter.kotlin_version}}")

    api("org.slf4j:slf4j-api:1.7.25")
    api("com.github.tony19:logback-android:2.0.0")

    implementation(project(":{{cookiecutter.module_name}}"))
}
