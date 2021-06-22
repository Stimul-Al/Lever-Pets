#[Pets](#Pets)
## [Description](#Description)
* A person can have an animal
* Animals are dogs and cats
* If person disappeared, his animals disappeared too
* Animal couldn't have owner
* Owners can swap animals

### [Maven compile & run commands](#Maven compile and run commands)
```mvn clean install -P <profile-id>```  
```mvn -P<profileId> spring-boot:run```  
`<profile-id>` is id of the profile for a build (**dev** or **prod**).  
**Example:** `mvn -Pdev spring-boot:run`


## [Database](#Database)
### [Jpa layer](#Jpa layer)

![](docs/img/entity.png)

### [Database layer](#Database layer)

![](docs/img/database_diagram.png)

## [Postman](#Postman)
Test Api by [Postman](docs/postman/Pets%20api.postman_collection.json)

## [Cloud](#Cloud)
![](docs/img/ondemand.com.png)


