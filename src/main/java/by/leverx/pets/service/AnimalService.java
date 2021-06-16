package by.leverx.pets.service;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.animal.AnimalFullDto;
import by.leverx.pets.dto.animal.AnimalUpdateDto;

import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
public interface AnimalService {

    AnimalFullDto findById(Long id);

    List<AnimalFullDto> findAll();

    AnimalFullDto create(AnimalCreateDto createDto);

    AnimalFullDto update(AnimalUpdateDto updateDto);

    void delete(Long id);
}
