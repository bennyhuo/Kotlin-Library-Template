[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)


# {{cookiecutter.project_name}}



# How to use

## Import

I have deployed these modules to maven central, you may add this in your build.gradle: 
 
```
implementation("{{cookiecutter.group}}:{{cookiecutter.artifact_id}}:{{cookiecutter.version}}")
```

### SNAPSHOT

If you want to try the dev version, add this to your build.gradle:

```
repositories {
    maven {
        url "https://oss.sonatype.org/service/local/repositories/snapshots/" 
    }
}

dependencies {
    implementation("{{cookiecutter.group}}:{{cookiecutter.artifact_id}}:{{cookiecutter.version}}-SNAPSHOT")
}
```

## API



# Link

- 


# Change Log

