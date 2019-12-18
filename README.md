# SpringBoot JPA with SAP HANA
A demo Java application leveraging Spring JPA with SAP HANA database.

## How to build and run?
```bash
$ gradle build
$ java -jar build/libs/springboot-jpa-hana-0.1.0.jar
```
Then open browser and visit http://localhost:8080/swagger-ui.html

## How to run directly?
```bash
$ gradle bootRun
```
Then open browser and visit http://localhost:8080/swagger-ui.html

## How to run with Docker?
```bash
$ docker build -t springboot-jpa-hana .
$ docker run -p 8080:8080 springboot-jpa-hana
```
Then open browser and visit http://localhost:8080/swagger-ui.html

## Caveats
- The solution only works with HANA 2.0 because it requires `select hibernate_sequence.nextval from sys.dummy` when auto generates Id.
- Append `database=MDC_NAME&encrypt=true&validateCertificate=false` to `spring.datasource.url` when applicable.
