import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.sonarqube") version "3.5.0.2730"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"

}

group = "br.com.ricas"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation ("io.mockk:mockk:1.9.3")
	implementation("org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184")
}

sonarqube {
	properties {
		property("sonar.projectName", "reactive-programming")
		property("sonar.projectKey", "br.com.ricas.reactiveprogramming")
		property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/jacoco/coverageReport/coverageReport.xml")
		property("sonar.sources", "src")
		property("sonar.exclusions", "src/**/test/**/*")
 	}
}
apply(plugin = "org.sonarqube")

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
