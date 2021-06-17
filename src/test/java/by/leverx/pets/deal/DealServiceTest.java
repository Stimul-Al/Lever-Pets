package by.leverx.pets.deal;

import by.leverx.pets.dto.deal.DealCreateDto;
import by.leverx.pets.dto.deal.DealFullDto;
import by.leverx.pets.integration.AbstractIntegrationTest;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.service.DealService;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

public class DealServiceTest extends AbstractIntegrationTest {

    @Autowired
    private DealService dealService;
    private AnimalRepository animalRepository;

    @Test
    void testDeal() {
        //given
        DealCreateDto dealCreateDto = new DealCreateDto();
        dealCreateDto.setFirstAnimal(1L);
        dealCreateDto.setSecondAnimal(4L);

        var beforeDealFirstAnimal = animalRepository.findById(1L).orElse(null);
        var beforeDealSecondAnimal = animalRepository.findById(4L).orElse(null);

        //when
        DealFullDto dto = dealService.deal(dealCreateDto);

        var afterDealFirstAnimal = animalRepository.findById(1L).orElse(null);
        var afterDealSecondAnimal = animalRepository.findById(4L).orElse(null);

        //then
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(beforeDealFirstAnimal.getPerson().getId(), afterDealSecondAnimal.getPerson().getId());
        Assertions.assertEquals(beforeDealSecondAnimal.getPerson().getId(), afterDealFirstAnimal.getPerson().getId());
    }

}
