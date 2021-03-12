# About

super-heroes-manager is a Java app for manage superheroes through a rest api.

## Prerequisites

* Java 11
* maven 3.6.0
* Docker

## Installation
### local
```bash
mvn clean install
mvn spring-boot:run
```
### docker
```bash
docker build -t superhero-manager .
docker run -p 8080:8080 superhero-manager
```

## Usage

Access http://localhost:8080/swagger-ui.html to view the exposed endpoints
