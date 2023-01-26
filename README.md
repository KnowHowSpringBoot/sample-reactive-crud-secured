# User Departments - Reactive app

[![Build Status](http://iaolg9igjr3tghootxslfe.webrelay.io/api/badges/ujar-org/bs-nb-reactor-acmedepartments/status.svg?ref=refs/heads/main)](http://iaolg9igjr3tghootxslfe.webrelay.io/ujar-org/bs-nb-reactor-acmedepartments)
[![Quality Gate Status](https://sonarqube.c2a2.com/api/project_badges/measure?project=ujar-org%3Abs-nb-reactor-acmedepartments&metric=alert_status&token=d5f9d10b327a765485133e3afb644075eea358c9)](https://sonarqube.c2a2.com/dashboard?id=ujar-org%3Abs-nb-reactor-acmedepartments)

Minimal Spring Boot based reactive CRUD example, which manages user entity (including Swagger UI).

## Technology stack

Java 17, Spring Boot, Webflux

## Prerequisites

The following items should be installed in your system:

* Java 17 or newer.
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE (IDEA preferably)

## Database configuration

Application uses a Postgres as a persistent storage. Options to get it up:

1. Use remote existing postgres. It is needed to specify the path in configs.
1. Start local postgres in docker `docker-compose -f docker-compose.dev.yml up -d`

### Running locally

This application is a [Spring Boot](https://spring.io/guides/gs/spring-boot) application built
using [Maven](https://spring.io/guides/gs/maven/). You can build a jar file and run it from the command line:

```
git clone https://github.com/ujar-org/bs-nb-reactor-acmedepartments.git
cd bs-nb-reactor-acmedepartments
./mvnw package
java -jar target/*.jar
```

You can then access Swagger UI here: http://localhost:8080/swagger-ui.html

### Working with Application in your IDE

1) On the command line

```
git clone https://github.com/ujar-org/bs-nb-reactor-acmedepartments.git
```

2) Inside IDE

In the main menu, choose `File -> Open` and select the Application [pom.xml](pom.xml). Click on the `Open` button.
Activate "local" profile in the Run settings or set it via environment
variables. [instruction](https://stackoverflow.com/questions/38520638/how-to-set-spring-profile-from-system-variable)
Wait to indexing completion and push the green "play" button.

3) Navigate to Swagger UI

Visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser.

## Code conventions

The code follows [Google Code Conventions](https://google.github.io/styleguide/javaguide.html). Code
quality is measured by:

- [Sonarqube](https://sonarqube.c2a2.com/dashboard?id=ujar-org%3Abs-nb-reactor-acmedepartments)
- [PMD](https://pmd.github.io/)
- [CheckStyle](https://checkstyle.sourceforge.io/)
- [SpotBugs](https://spotbugs.github.io/)

### Tests

This project has standard JUnit tests. To run them execute this command:

```text
./mvnw test -P testcontainers-support
```
