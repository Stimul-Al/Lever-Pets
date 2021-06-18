package by.leverx.pets.deal;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.integration.AbstractIntegrationTest;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        var ownerFirstAnimalBefore = personRepository.findByAnimalId(dealCreateDto.getFirstAnimal()).orElse(null);
        var ownerSecondAnimalBefore = personRepository.findByAnimalId(dealCreateDto.getSecondAnimal()).orElse(null);

        //when
        dealService.deal(dealCreateDto);

        var ownerFirstAnimalAfter = personRepository.findByAnimalId(dealCreateDto.getFirstAnimal()).orElse(null);
        var ownerSecondAnimalAfter = personRepository.findByAnimalId(dealCreateDto.getSecondAnimal()).orElse(null);

        //then
        assertEquals(ownerFirstAnimalBefore.getId(), ownerSecondAnimalAfter.getId());
        assertEquals(ownerSecondAnimalBefore.getId(), ownerFirstAnimalAfter.getId());
    }

}
