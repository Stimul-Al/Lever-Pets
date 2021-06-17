package by.leverx.pets.service.impl;

import by.leverx.pets.dto.deal.DealCreateDto;
import by.leverx.pets.dto.deal.DealFullDto;
import by.leverx.pets.entity.Animal;
import by.leverx.pets.entity.Deal;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.exception.PersonNotFoundException;
import by.leverx.pets.mapper.DealMapper;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.repository.DealRepository;
import by.leverx.pets.repository.PersonRepository;
import by.leverx.pets.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static by.leverx.pets.mapper.DealMapper.DEAL_MAPPER;
import static java.time.LocalDateTime.now;

@Slf4j
@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final AnimalRepository animalRepository;
    private final DealRepository dealRepository;

    @Override public DealFullDto deal(DealCreateDto createDto) {
        var firstAnimal = getAnimal(createDto.getFirstAnimal());
        var secondAnimal = getAnimal(createDto.getSecondAnimal());

        var dealToSave = Deal.builder()
                .dealDate(now())
                .firstAnimal(firstAnimal)
                .secondAnimal(secondAnimal)
                .build();

        dealRepository.save(dealToSave);

        animalRepository.dealTwoAnimals(firstAnimal.getId(), firstAnimal.getPerson().getId(), secondAnimal.getId(), secondAnimal.getPerson().getId());

        log.info("DealService -> Deal well done. Deal id:{}", dealToSave.getId());
        return DEAL_MAPPER.mapToFullDto(dealToSave);
    }

    private Animal getAnimal(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }
}
