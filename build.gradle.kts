plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "xyz.acrylicstyle"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") }
    maven { url = uri("https://repo.acrylicstyle.xyz/") }
    maven { url = uri("https://repo2.acrylicstyle.xyz/") }
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("xyz.acrylicstyle:api:0.5.18")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
        kotlinOptions.freeCompilerArgs = listOf(
            "-Xjsr305=strict"
        )
    }

    withType<JavaCompile>().configureEach {
        options.encoding = "utf-8"
    }

    withType<ProcessResources> {
        filteringCharset = "UTF-8"
        from(sourceSets.main.get().resources.srcDirs) {
            include("**")

            val tokenReplacementMap = mapOf(
                "version" to project.version,
                "name" to project.rootProject.name
            )

            filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to tokenReplacementMap)
        }

        from(projectDir) { include("LICENSE") }
    }

    withType<Jar> {
        archiveFileName.set("AmongUs.jar")
        from(configurations.getByName("implementation").apply{ isCanBeResolved = true }.map { if (it.isDirectory) it else zipTree(it) })
    }
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = "1.4"
}
