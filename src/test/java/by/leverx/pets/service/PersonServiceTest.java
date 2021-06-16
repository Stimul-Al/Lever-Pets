package by.leverx.pets.service;

import by.leverx.pets.dto.person.PersonUpdateDto;
import by.leverx.pets.integration.AbstractIntegrationTest;
import lombok.var;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static by.leverx.pets.utils.UtilDto.getPersonCreateDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author aliaksei.babashau
 */
public class PersonServiceTest extends AbstractIntegrationTest {

    @Test
    void createTest() {
        //given

        //when
        var createdPerson = personService.create(getPersonCreateDto());

        //then
        assertNotNull(createdPerson.getId());
    }

    @Test
    void updateTest() {
        //given
        long existingId = 2;
        var existingPerson = personService.findById(existingId);
        PersonUpdateDto personUpdateDto = new PersonUpdateDto();
        personUpdateDto.setId(existingPerson.getId());
        personUpdateDto.setName("Alexei");

        //when
        var updatedPerson = personService.update(personUpdateDto);

        //then
        assertNotNull(updatedPerson.getId());
        assertEquals(updatedPerson.getId(), personUpdateDto.getId());
        assertNotNull(updatedPerson.getName(), personUpdateDto.getName());
    }

    @Test
    void findPersonById_happyPath() {
        //given
        long existingId = 2;

        //when
        var foundPerson = personService.findById(existingId);

        //then
        assertNotNull(foundPerson);
        assertEquals(foundPerson.getId(), existingId);
    }

    @Test
    void findByEmail() {
        //given
        String existingEmail = "Jhon@gmail.com";

        //when
        var person = personService.findByEmail(existingEmail);

        //then
        assertNotNull(person);
    }

    @Test
    void findAll() {
        //given

        //when
        var persons = personService.findAll();

        //then
        assertNotNull(persons);
    }

    @Test
    void delete() {
        //given
        long existingId = 1;

        //when
        personService.delete(existingId);

        //then
        assertThrows(EntityNotFoundException.class, () -> personService.findById(existingId));
    }
}
