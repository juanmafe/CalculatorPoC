# SanitasCalculator
POC Sanitas Calculator API

# Information
* Java 17
* Spring Boot 2.7.3

# Tools
* Apicurio: https://studio.apicur.io/dashboard

# Requirements
* Tracer-1.0.0.jar
* To install the jar dependency locally in the .m2 folder:
```
mvn install:install-file -Dfile=tracer-1.0.0.jar -DgroupId=io.corp.calculator -DartifactId=tracer
-Dversion=1.0.0 -Dpackaging=jar -DgeneratePom=true
```

# How to run the app
* Execute this command in the root folder of the project
```
mvn spring-boot:run
```