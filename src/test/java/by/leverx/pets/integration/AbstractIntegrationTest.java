package by.leverx.pets.integration;

import by.leverx.pets.PetsApplication;
import by.leverx.pets.integration.init.MySqlInitializer;
import by.leverx.pets.service.AnimalService;
import by.leverx.pets.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

/**
 *
 * @author aliaksei.babashau
 */
@Testcontainers
@SpringBootTest
@ContextConfiguration(initializers = MySqlInitializer.class,
        classes = PetsApplication.class)
// CHECKSTYLE:OFF
public abstract class AbstractIntegrationTest {

    @Autowired
    protected PersonService personService;

    @Autowired
    protected AnimalService animalService;
}
// CHECKSTYLE:ON



