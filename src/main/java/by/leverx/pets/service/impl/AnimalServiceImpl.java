package by.leverx.pets.service.impl;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.animal.AnimalFullDto;
import by.leverx.pets.dto.animal.AnimalUpdateDto;
import by.leverx.pets.entity.Animal;
import by.leverx.pets.exception.exception.AnimalNotFoundException;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.leverx.pets.mapper.AnimalMapper.ANIMAL_MAPPER;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author aliaksei.babashau
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Transactional(readOnly = true)
    @Override public AnimalFullDto findById(Long id) {
        AnimalFullDto animalFullDto = animalRepository.findById(id)
                .map(ANIMAL_MAPPER::mapToDto)
                .orElseThrow(() -> new AnimalNotFoundException(id));

        log.info("AnimalService -> found Animal by Id: {}", id);
        return animalFullDto;
    }

    @Transactional(readOnly = true)
    @Override public List<AnimalFullDto> findAll() {
        List<AnimalFullDto> animalFullDtos = animalRepository.findAll().stream()
                .map(ANIMAL_MAPPER::mapToDto)
                .collect(toList());

        log.info("AnimalService -> found Animals {}", animalFullDtos.size());
        return animalFullDtos;
    }

    @Transactional
    @Override public AnimalFullDto create(AnimalCreateDto createDto) {
        Animal animalToSave = ANIMAL_MAPPER.mapToEntity(createDto);

        var savedAnimal = animalRepository.save(animalToSave);

        log.info("AnimalService -> created Animal by id {}", savedAnimal.getId());
        return ANIMAL_MAPPER.mapToDto(savedAnimal);
    }

    @Transactional
    @Override public AnimalFullDto update(AnimalUpdateDto updateDto) {
        Animal existingEntity = animalRepository.findById(updateDto.getId())
                .orElseThrow(() -> new AnimalNotFoundException(updateDto.getId()));

        var changedAnimal = fillFieldsEntity(existingEntity, updateDto);
        animalRepository.save(changedAnimal);

        log.info("AnimalService -> updated Animal by id {}", existingEntity.getId());
        return ANIMAL_MAPPER.mapToDto(changedAnimal);
    }

    private Animal fillFieldsEntity(Animal animal, AnimalUpdateDto updateDto) {
        animal.setTypeAnimal(updateDto.getTypeAnimal());
        animal.setName(updateDto.getName());

        return animal;
    }

    @Transactional
    @Override public void delete(Long id) {
        if (!animalRepository.existsById(id)) {
            throw new AnimalNotFoundException(id);
        }

        log.info("AnimalService -> deleted Animal by id {}", id);
        animalRepository.deleteById(id);
    }
}
