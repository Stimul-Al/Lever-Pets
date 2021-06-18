package by.leverx.pets.service.impl;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.entity.Animal;
import by.leverx.pets.entity.Person;
import by.leverx.pets.exception.AnimalNotFoundException;
import by.leverx.pets.exception.AnimalSameException;
import by.leverx.pets.exception.PersonSameException;
import by.leverx.pets.repository.AnimalRepository;
import by.leverx.pets.repository.PersonRepository;
import by.leverx.pets.service.DealService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final AnimalRepository animalRepository;

    private final PersonRepository personRepository;

    @Transactional
    @Override public void deal(DealDto dealDto) {

        var ownersFirstAnimal = getPersonsByAnimalId(dealDto.getFirstAnimal());
        var ownersSecondAnimal = getPersonsByAnimalId(dealDto.getSecondAnimal());

        var firstAnimal = getAnimal(dealDto.getFirstAnimal());
        var secondAnimal = getAnimal(dealDto.getSecondAnimal());

        validate(ownersFirstAnimal, ownersSecondAnimal, firstAnimal, secondAnimal);

        saveChanges(exchangeAnimals(ownersFirstAnimal, firstAnimal, secondAnimal),
                        exchangeAnimals(ownersSecondAnimal, secondAnimal, firstAnimal));
    }

    private void saveChanges(List<Person> ownersFirstAnimal, List<Person> ownersSecondAnimal) {
        personRepository.saveAll(ownersFirstAnimal);
        personRepository.saveAll(ownersSecondAnimal);
    }

    private List<Person> exchangeAnimals(List<Person> owners, Animal from, Animal to) {
        owners.forEach(owner -> owner.getAnimals().remove(from));
        owners.forEach(owner -> owner.getAnimals().add(to));

        return owners;
    }

    private List<Person> getPersonsByAnimalId(Long animalId) {
        return personRepository.findByAnimalId(animalId);
    }

    private Animal getAnimal(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException(id));
    }

    private void validate(List<Person> ownersSecondAnimal, List<Person> ownersFirstAnimal, Animal firstAnimal, Animal secondAnimal) {
        validateAnimal(firstAnimal.getId(), secondAnimal.getId());
        validatePerson(ownersFirstAnimal, ownersSecondAnimal);
    }

    private void validatePerson(List<Person> first, List<Person> second) {
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
