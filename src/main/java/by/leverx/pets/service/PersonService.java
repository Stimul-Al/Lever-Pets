package by.leverx.pets.service;

import by.leverx.pets.dto.person.PersonCreateDto;
import by.leverx.pets.dto.person.PersonFullDto;
import by.leverx.pets.dto.person.PersonPreviewDto;
import by.leverx.pets.dto.person.PersonUpdateDto;

import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
public interface PersonService {

    PersonFullDto findById(Long id);

    PersonFullDto findByEmail(String email);

    List<PersonPreviewDto> findAll();

    PersonFullDto create(PersonCreateDto createDto);

    PersonFullDto update(PersonUpdateDto updateDto);

    void delete(Long id);
}
