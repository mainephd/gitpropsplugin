# gitprops

## What is it?

gitprops is a [Gradle](http://gradle.org) plugin:

* provides an easy way to write out git information to the git properties file for usage by sprint boot's /info endpoint

See [Grgit](https://github.com/ajoberstar/grgit) for details on the Git library used underneath, including
configuration for authentication.

## Usage

**NOTE:** requires Java 7 (or higher)

* add plugin repository to your buildscript
* apply plugin: com.homedepot.gitprops
* add dependsOn to include it in your build pipeline - project.tasks.jar.dependsOn('gitprops')

```javascript
buildscript {
    repositories {
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.homedepot.gitprops:GitPropsPlugin:1.0.6")
    }
}
apply plugin: 'com.homedepot.gitprops'
```

* see also ./example/build.gradle

## Acknowledgements

This very simple plugin makes uses of the incredible work done by Andrew Oberstar on the [gradle-git plugin](https://github.com/ajoberstar), which provides additional flexibility and functionality

Significant simplification of original plugin based on [article](http://www.insaneprogramming.be/blog/2014/08/15/spring-boot-info-git/) by Lieven Doclo

## TODO

* add environment sanity checks (git installed, in a git repository, etc)
* add additional error messages (windows specific problems)
* add Wercker
