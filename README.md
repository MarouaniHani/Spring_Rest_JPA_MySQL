# Spring_Rest_JPA_MySQL

### 1.You can clone it from github by running following command
```
 $ git clone hhttps://github.com/MarouaniHani/Spring_Rest_JPA_MySQL.git
 ```
 ### 2.Import project into eclipse
 ```
 File -> Import -> Maven -> Existing Maven Projects -> Browse Project from cloned location
```
 ### 3.Right click on project in eclipse and then Maven -> Update Projects
 ### 4.Update database credential and other configuration into application.properties available in src/main/java/resources
 ```
 ## Spring DATASOURCE (DataSourceAutoConfiguration & DataSourceProperties)
spring.datasource.url = jdbc:mysql://localhost:13306/rest_spring?useSSL=false
spring.datasource.username = root
spring.datasource.password = 


## Hibernate Properties
# The SQL dialect makes Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5InnoDBDialect

# Hibernate ddl auto (create, create-drop, validate, update)
spring.jpa.hibernate.ddl-auto = update


server.port=18080
```
 ### 5.Right click on Application.java file and run as Java Application
 ### Once Sprint Boot Application will be started successfully then we
 can call following Endpoints by using POSTMAN
 ### 6.To get list of notes call following endpoint with GET Request
```
http://localhost:18080/api/notes
```
### 7.To Create New note use following url with POST Request
```
http://localhost:18080/api/notes
```
### set content type as in header as ´´´ application/json ´´´
### set request body as raw with JSON payload
```
  {
    "title": "test",
    "content": "test"
  }
```
### 8.To get a particular note, use following url with GET request type in postman
```
http://localhost:18080/api/notes/<id>
```
### 9.To update note in database, use following url with PUT request type in postman
```
http://localhost:18080/api/notes/<id>
```
### set content type as in header as ´´´ application/json ´´´
```
  {
    "title": "test_after_put",
    "content": "test"
  }
```
### 10.To delete a particular Book from database, use following url with DELETE request type in postman
```
 http://localhost:18080/api/notes/<id>
```
### Note - Replace with actual id




