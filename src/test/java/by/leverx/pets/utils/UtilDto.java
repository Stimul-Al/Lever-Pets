package by.leverx.pets.utils;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.person.PersonCreateDto;
import by.leverx.pets.entity.enums.TypeAnimal;

import static by.leverx.pets.entity.enums.TypeAnimal.CAT;
import static java.util.Arrays.asList;

/**
 *
 * @author aliaksei.babashau
 */
public class UtilDto {

    public static PersonCreateDto getPersonCreateDto() {
        String email = "alex@gmail.com";
        AnimalCreateDto animalCreateDto = AnimalCreateDto.builder()
                .name("Sam")
                .typeAnimal(CAT)
                .build();

        return PersonCreateDto.builder()
                .name("Alex")
                .email(email)
                .password("qwerty12345")
                .animals(asList(animalCreateDto))
                .build();
    }

    public static AnimalCreateDto getAnimalCreateDto() {
        return AnimalCreateDto.builder()
                .name("Tom")
                .typeAnimal(CAT)
                .build();
    }
}