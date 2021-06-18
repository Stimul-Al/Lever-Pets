package by.leverx.pets.service.impl;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.entity.Animal;
import by.leverx.pets.entity.Person;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.exception.AnimalSameException;
import by.leverx.pets.exception.PersonNotFoundException;
import by.leverx.pets.exception.PersonSameException;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.repository.PersonRepository;
import by.leverx.pets.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final AnimalRepository animalRepository;

    private final PersonRepository personRepository;

    @Override public void deal(DealDto dealDto) {
        validateAnimal(dealDto.getFirstAnimal(), dealDto.getSecondAnimal());

        var personFirstAnimal = getPersonByAnimalId(dealDto.getFirstAnimal());
        var personSecondAnimal = getPersonByAnimalId(dealDto.getSecondAnimal());

        validatePerson(personFirstAnimal, personSecondAnimal);

        var firstAnimal = getAnimal(dealDto.getFirstAnimal());
        var secondAnimal = getAnimal(dealDto.getSecondAnimal());

        personFirstAnimal.getAnimals().remove(firstAnimal);
        personFirstAnimal.getAnimals().add(secondAnimal);

        personSecondAnimal.getAnimals().remove(secondAnimal);
        personSecondAnimal.getAnimals().add(firstAnimal);

        personRepository.save(personFirstAnimal);
        personRepository.save(personSecondAnimal);

//        animalRepository.dealTwoAnimals(personSecondAnimal.getId(), dealDto.getFirstAnimal());
//        animalRepository.dealTwoAnimals(personFirstAnimal.getId(), dealDto.getSecondAnimal());
    }

    private Person getPersonByAnimalId(Long animalId) {
        return personRepository.findByAnimalId(animalId)
                .orElseThrow(() -> new PersonNotFoundException("Person not found by animal Id:", animalId));
    }

    private Animal getAnimal(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    private void validatePerson(Person first, Person second) {
        if (first.equals(second)) {
            throw new PersonSameException("Owner of both pets");
        }
    }

    private void validateAnimal(Long firstId, Long secondId) {
        if (firstId.equals(secondId)) {
            throw new AnimalSameException("The same animal");
        }
    }
}
