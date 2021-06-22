#Pets
___
## [Description](#description)
___
* A person can have an animal
* Animals are dogs and cats
* If person disappeared, his animals disappeared too
* Animal couldn't have owner
* Owners can swap animals

### [Maven compile & run commands](#maven_compile_and_run_commands)
```mvn clean install -P <profile-id>```  
```mvn -P<profileId> spring-boot:run```  
`<profile-id>` is id of the profile for a build (**dev** or **prod**).  
**Example:** `mvn -Pdev spring-boot:run`


## [Database](#database)
___
### [Jpa layer](#jpa_layer)

![](docs/img/entity.png)

### [Database layer](#database_layer)

![](docs/img/database_diagram.png)

## [Postman](#postman)
___
Test Api by [Postman](docs/postman/Pets%20api.postman_collection.json)

## [Cloud](#cloud)
___
![](docs/img/ondemand.com.png)


