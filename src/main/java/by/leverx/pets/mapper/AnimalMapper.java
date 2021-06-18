package by.leverx.pets.mapper;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.animal.AnimalFullDto;
import by.leverx.pets.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author aliaksei.babashau
 */
@Mapper(uses = PersonMapper.class)
public interface AnimalMapper {

    AnimalMapper ANIMAL_MAPPER = Mappers.getMapper(AnimalMapper.class);

    AnimalFullDto mapToDto(Animal animal);

    Animal mapToEntity(AnimalCreateDto createDto);

}
