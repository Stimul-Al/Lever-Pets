# Pets

## Description

### General description
* A person can have several animals
* Animal can have several owners
* Animals are dogs or cats
* Removing a person leads to the removal of his animals
* Owners can exchange animals

### Maven compile & run commands
```
mvn clean install -P <profile-id>
```  
```
mvn -P<profileId> spring-boot:run
```  
`<profile-id>` it is id of the profile for a build (**dev** or **prod**).  

**Example:** `mvn -Pdev spring-boot:run`


## Database
### Jpa layer

![](docs/img/entity.png)

### Database layer

![](docs/img/database_diagram.png)

## Postman
Test Api by [Postman](docs/postman/Pets%20api.postman_collection.json)

## Cloud
![](docs/img/ondemand.com.png)


