# SpringBoot JPA with HANA
A demo Java application leveraging Spring JPA with SAP HANA database.

## How to build and run?
```bash
$ gradle build
$ java -jar build/libs/springboot-jpa-hana-0.1.0.jar
```
Then open browser and visit http://localhost:8080

## How to run directly
```bash
$ gradle bootRun
```
Then open browser and visit http://localhost:8080

## How to run with Docker
```bash
$ docker build -t springboot-jpa-hana .
$ docker run -v 8080:8080 springboot-jpa-hana
```
Then open browser and visit http://localhost:8080
