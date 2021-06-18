package by.leverx.pets.deal;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.integration.AbstractIntegrationTest;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.service.DealService;
import lombok.var;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aliaksei.babashau
 */
public class DealServiceTest extends AbstractIntegrationTest {

    @Autowired
    private DealService dealService;

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void testDeal() {
        //given
        DealDto dealCreateDto = new DealDto();
        dealCreateDto.setFirstAnimal(1L);
        dealCreateDto.setSecondAnimal(4L);

        var beforeDealFirstAnimal = animalRepository.findById(1L).orElseThrow(() -> new AnimalNotFoundException(1L));
        var beforeDealSecondAnimal = animalRepository.findById(4L).orElseThrow(() -> new AnimalNotFoundException(4L));

        //when
        dealService.deal(dealCreateDto);

        var afterDealFirstAnimal = animalRepository.findById(1L).orElseThrow(() -> new AnimalNotFoundException(1L));
        var afterDealSecondAnimal = animalRepository.findById(4L).orElseThrow(() -> new AnimalNotFoundException(4L));

        //then
//        Assertions.assertEquals(beforeDealFirstAnimal.getPerson().getId(), afterDealSecondAnimal.getPerson().getId());
//        Assertions.assertEquals(beforeDealSecondAnimal.getPerson().getId(), afterDealFirstAnimal.getPerson().getId());
    }

}
