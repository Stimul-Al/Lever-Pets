# Pets

## Description

### General description
* A person can have an animal
* Animals are dogs and cats
* If person disappeared, his animals disappeared too
* Animal couldn't have owner
* Owners can swap animals

### Maven compile & run commands
```
mvn clean install -P <profile-id>
```  
```
mvn -P<profileId> spring-boot:run
```  
`<profile-id>` is id of the profile for a build (**dev** or **prod**).  
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


