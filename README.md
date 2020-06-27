# employee-service-api

This is a test project, a Rest Api to demonstrate employee management using with Spring Boot. It contains,

- Store, update, delete and retrieve employee data.
- Store/Update employee data.
- Assign/Change employee to department.
- Assign/Change employee to supervisor, salary scale and office related detail.
- Add/Update/Delete employee family member details.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Mysql](https://www.mysql.com/) for local setup
- [postgresql](https://www.postgresql.org/) for heroku

## Tech Stack

- Spring Boot
- Swagger for Api documentation
- Heroku for Deployment
- Maven for dependency and application life cycle management
- Lombok for genarating boilerplate for entities
- Spring data JPA for database transaction management

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.dasun.employeedemo.EmployeeDemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Also you can build an executable jar 

```shell
mvn clean install
```
and it will provide an executable jar in target directory you can run using 

```shell
java -jar path-to-jar
```

## Deploying the application to Heroku

The easiest way to deploy the sample application to Heroku is to use the [Heroku CLI](https://dashboard.heroku.com/):

This will create and rest api:

* Heroku App: employee-service-api
* Swagger Url: https://employee-service-api.herokuapp.com/swagger-ui.html#

