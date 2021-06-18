package by.leverx.pets.repository;

import by.leverx.pets.entity.Animal;
import by.leverx.pets.entity.Person;
import by.leverx.pets.integration.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static by.leverx.pets.entity.enums.TypeAnimal.CAT;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author aliaksei.babashau
 */
public class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void createTest() {
        //given
        Animal animal = Animal.builder()
                .typeAnimal(CAT)
                .name("space")
                .build();

        Person person = Person.builder()
                .animals(asList(animal))
                .name("Alex")
                .password("12345678")
                .email("alexmail@mail.ru")
                .build();

        animal.setPersons(asList(person));

        //when
        personRepository.save(person);

        //then
        assertNotNull(person.getId());
    }
}
