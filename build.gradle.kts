plugins {
    id("com.orange.foundation.jvm.application") version "0.1.0"
    id("io.micronaut.application") version "2.0.6"
    id ("org.sonarqube") version "3.3"
}

version = "0.1"
group = "br.com.marcelodaniel.orangestack"

val micronautVersion: String by project
val artifactoryUrl: String by project
val foundationMicronautVersion: String by project
val kotlinVersion: String by project

dependencies {

    kapt(platform("io.micronaut:micronaut-bom:$micronautVersion"))
    kapt("io.micronaut:micronaut-inject-java")

    implementation(platform("com.orange.foundation.jvm:micronaut:$foundationMicronautVersion"))
    implementation("micronaut:rest-server")

    //tests
    kaptTest("io.micronaut:micronaut-inject-java")
}

repositories {
    mavenLocal()
    mavenCentral()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
    maven {
        url = uri(artifactoryUrl)
    }
}

application {
    mainClass.set("br.com.marcelodaniel.orangestack.ApplicationKt")
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.orange.foundation.jvm.*", "br.com.marcelodaniel.orangestack.*")
    }
}

tasks {
    "shadowJar"(com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar::class) {
        isZip64 = true
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

sonarqube {
    properties {
        property ("sonar.projectKey", "domainservices-back-kotlin-rest-app")
    }
}