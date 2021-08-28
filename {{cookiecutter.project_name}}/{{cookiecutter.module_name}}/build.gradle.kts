plugins {
    kotlin("jvm")

    id("com.vanniktech.maven.publish")
}

group = "{{cookiecutter.group}}"
version = "{{cookiecutter.version}}"

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.25")

    testImplementation("junit:junit:4.12")
}
