plugins {
    id("java")
}

group = "com.github.mexvav"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("org.jetbrains:annotations:24.0.1")
    implementation("com.google.guava:guava:31.1-jre")
    
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}