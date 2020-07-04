# Spring Boot RESTful API Example

## Prerequisite
* Installed Java 11. Highly recommended to use OpenJDK, because free in production. 
  You can choose [Adopt OpenJDK](https://adoptopenjdk.net), one of the most popular distributions.
* Installed [Maven 3](https://maven.apache.org/install.html) 
* Installed MySQL Server and configure the [application.properties](/src/main/resources/application.properties) file 
  according to what you have. Don't forget to create database that will be used!

## Run Application
Type and execute the following command on your terminal

```bash
$ mvn spring-boot:run
```

## APIs Call Example

Create User API
```bash
$ curl -X  POST 'localhost:8080/api/v1/users' \
-H 'Content-Type: application/json' \
-d '{"name":"Arip", "email":"arip@email.com", "password":"rahasia"}'
```

Get All Users
```bash
$ curl -X GET 'localhost:8080/api/v1/users'
```

Get User By Id
```bash
$ curl -X GET 'localhost:8080/api/v1/users/[user id here]'
```

Update User By Id
```bash
$ curl -X PUT 'localhost:8080/api/v1/users/[user id here]' \
-H 'Content-Type: application/json' \
-d '{"name":"Hidayat", "email":"hidayat@email.com", "password":"rahasia123"}'
```

Delete User By Id
```bash
$ curl -X DELETE 'localhost:8080/api/v1/users/[user id here]'
```