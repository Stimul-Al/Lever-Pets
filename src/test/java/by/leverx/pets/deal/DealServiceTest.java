package by.leverx.pets.deal;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.integration.AbstractIntegrationTest;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aliaksei.babashau
 */
public class DealServiceTest extends AbstractIntegrationTest {

    @Test
    void testDeal() {
        //given
        DealDto dealCreateDto = new DealDto();
        dealCreateDto.setFirstAnimal(1L);
        dealCreateDto.setSecondAnimal(4L);

        var beforeFirstAnimal = animalRepository.findById(1L).orElseThrow(() -> new AnimalNotFoundException(1L));
        var beforeSecondAnimal = animalRepository.findById(4L).orElseThrow(() -> new AnimalNotFoundException(4L));

        //when
        dealService.deal(dealCreateDto);

        var afterFirstAnimal = animalRepository.findById(1L).orElseThrow(() -> new AnimalNotFoundException(1L));
        var afterSecondAnimal = animalRepository.findById(4L).orElseThrow(() -> new AnimalNotFoundException(4L));

        //then
        Assertions.assertEquals(beforeFirstAnimal.getPersons().get(0).getId(), afterSecondAnimal.getPersons().get(0).getId());
    }

}
