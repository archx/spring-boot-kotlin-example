import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.5.8"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.5.32"
    kotlin("plugin.spring") version "1.5.32"
    kotlin("plugin.allopen") version "1.5.32"
    kotlin("plugin.noarg") version "1.5.32"
}

group = "com.example"
version = "1.0.0"
java.sourceCompatibility = JavaVersion.VERSION_11

allOpen {
    annotation("com.example.common.extension.annotation.AllOpen")
}

noArg {
    annotation("com.example.common.extension.annotation.NoArgsConstructor")
}

repositories {
    mavenLocal()
    maven { url = uri("'https://maven.aliyun.com/repository/public/") }
    maven { url = uri("'https://maven.aliyun.com/repository/spring/") }
    mavenCentral()
}

configurations {
    implementation {
        exclude(module = "spring-boot-starter-tomcat")
        exclude(module = "slf4j-log4j12")
        exclude(module = "junit")
    }
}

configurations.all {
    // Aligning log4j dependency versions to 2.17.1
    resolutionStrategy.eachDependency {
        if (requested.group == "org.apache.logging.log4j") {
            useVersion("2.17.1")
        }
    }
}

val jwtVersion = "0.11.2"
val swaggerVersion = "3.0.0"
val knife4jVersion = "3.0.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-undertow")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // jwt
    implementation("io.jsonwebtoken:jjwt-api:$jwtVersion")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:$jwtVersion")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jwtVersion")

    // swagger 3
    implementation("io.springfox:springfox-boot-starter:$swaggerVersion")
    implementation("com.github.xiaoymin:knife4j-spring-boot-starter:$knife4jVersion")

    // https://mvnrepository.com/artifact/com.baomidou/mybatis-plus-boot-starter
    implementation("com.baomidou:mybatis-plus-boot-starter:3.5.0")

    // https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp
    implementation("com.squareup.okhttp3:okhttp:4.9.3")


    developmentOnly("org.springframework.boot:spring-boot-devtools")

    runtimeOnly("mysql:mysql-connector-java")

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
