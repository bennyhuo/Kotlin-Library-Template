plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android-extensions")

    id("com.vanniktech.maven.publish")
}

group = "{{cookiecutter.group}}"
version = "{{cookiecutter.version}}"

android {
    compileSdkVersion(30)

    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        consumerProguardFiles("proguard-rules.pro")
    }

    buildTypes {
        val release by getting {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to arrayOf("*.jar")))

    implementation("org.slf4j:slf4j-api:1.7.25")

    testImplementation("junit:junit:4.12")
}
