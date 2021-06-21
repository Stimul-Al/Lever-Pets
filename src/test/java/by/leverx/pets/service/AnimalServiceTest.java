package by.leverx.pets.service;

import by.leverx.pets.dto.animal.AnimalUpdateDto;
import by.leverx.pets.integration.AbstractIntegrationTest;
import lombok.var;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static by.leverx.pets.utils.UtilDto.getAnimalCreateDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author aliaksei.babashau
 */
public class AnimalServiceTest extends AbstractIntegrationTest {

    @Test
    void createTest() {
        //given

        //when
        var animalFullDto = animalService.create(getAnimalCreateDto());

        //then
        assertNotNull(animalFullDto.getId());
    }

    @Test
    void updateTest() {
        //given
        long existingId = 2;
        var existingAnimal = animalService.findById(existingId);
        AnimalUpdateDto animalUpdateDto = new AnimalUpdateDto();
        animalUpdateDto.setId(existingAnimal.getId());
        animalUpdateDto.setName("Din");

        //when
        var updatedAnimal = animalService.update(animalUpdateDto);

        //then
        assertNotNull(updatedAnimal.getId());
        assertEquals(updatedAnimal.getId(), animalUpdateDto.getId());
        assertNotNull(updatedAnimal.getName(), animalUpdateDto.getName());
    }

    @Test
    void findAnimalById_happyPath() {
        //given
        long existingId = 2;

        //when
        var foundAnimal = animalService.findById(existingId);

        //then
        assertNotNull(foundAnimal);
        assertEquals(foundAnimal.getId(), existingId);
    }

    @Test
    void findAll() {
        //given

        //when
        var persons = animalService.findAll();

        //then
        assertNotNull(persons);
    }

    @Test
    void delete() {
        //given
        long existingId = 8;

        //when
        animalService.delete(existingId);

        //then
        assertThrows(EntityNotFoundException.class, () -> animalService.findById(existingId));
    }
}
