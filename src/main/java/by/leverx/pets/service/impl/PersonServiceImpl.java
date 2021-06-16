package by.leverx.pets.service.impl;

import by.leverx.pets.dto.person.PersonCreateDto;
import by.leverx.pets.dto.person.PersonFullDto;
import by.leverx.pets.dto.person.PersonPreviewDto;
import by.leverx.pets.dto.person.PersonUpdateDto;
import by.leverx.pets.entity.Animal;
import by.leverx.pets.entity.Person;
import by.leverx.pets.exception.PersonNotFoundException;
import by.leverx.pets.repository.PersonRepository;
import by.leverx.pets.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static by.leverx.pets.mapper.AnimalMapper.ANIMAL_MAPPER;
import static by.leverx.pets.mapper.PersonMapper.PERSON_MAPPER;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author aliaksei.babashau
 */
@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Transactional(readOnly = true)
    @Override public PersonFullDto findById(Long id) {
        PersonFullDto personFullDto = personRepository.findById(id)
                .map(PERSON_MAPPER::mapToDto)
                .orElseThrow(() -> new PersonNotFoundException(id));

        log.info("PersonService -> found person by Id: {}", id);
        return personFullDto;
    }

    @Override public PersonFullDto findByEmail(String email) {
        PersonFullDto personFullDto = personRepository.findByEmail(email)
                .map(PERSON_MAPPER::mapToDto)
                .orElseThrow(() -> new PersonNotFoundException(email));

        log.info("PersonService -> found person by email: {}", email);
        return personFullDto;
    }

    @Transactional(readOnly = true)
    @Override public List<PersonPreviewDto> findAll() {
        List<PersonPreviewDto> personPreviewDtos =
                personRepository.findAll()
                        .stream()
                        .map(PERSON_MAPPER::mapToPreviewDto)
                        .collect(toList());

        log.info("PersonService -> found persons. Count person: {}", personPreviewDtos.size());
        return personPreviewDtos;
    }

    @Override public PersonFullDto create(PersonCreateDto createDto) {
        Person personToSave = PERSON_MAPPER.mapToEntity(createDto);

        personToSave.getAnimals().forEach(animal -> animal.setPerson(personToSave));
        var savedPerson = personRepository.save(personToSave);

        log.info("PersonService -> created person. Id: {}", savedPerson.getId());
        return PERSON_MAPPER.mapToDto(savedPerson);
    }

    @Override public PersonFullDto update(PersonUpdateDto updateDto) {
        Person existingPerson = personRepository.findById(updateDto.getId())
                .orElseThrow(() -> new PersonNotFoundException(updateDto.getId()));

        var changedPerson = fillFieldsPerson(existingPerson, updateDto);
        personRepository.save(changedPerson);

        log.info("PersonService -> updated person. Id: {}", changedPerson.getId());
        return PERSON_MAPPER.mapToDto(changedPerson);
    }

    private Person fillFieldsPerson(Person personToChange, PersonUpdateDto updateDto) {
        List<Animal> animals =
                updateDto.getAnimals().stream()
                        .map(ANIMAL_MAPPER::mapToEntity)
                        .collect(toList());

        personToChange.setName(updateDto.getName());
        personToChange.setAnimals(animals);

        return personToChange;
    }

    @Override public void delete(Long id) {
        if (!personRepository.existsById(id)) {
            throw new PersonNotFoundException(id);
        }

        log.info("PersonService -> deleted person. Id: {}", id);
        personRepository.deleteById(id);
    }
}
