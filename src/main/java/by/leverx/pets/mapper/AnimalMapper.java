package by.leverx.pets.mapper;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.animal.AnimalFullDto;
import by.leverx.pets.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author aliaksei.babashau
 */
@Mapper
public interface AnimalMapper {

    AnimalMapper ANIMAL_MAPPER = Mappers.getMapper(AnimalMapper.class);

    @Mapping(target = "personId", source = "person.id")
    AnimalFullDto mapToDto(Animal animal);

    Animal mapToEntity(AnimalFullDto fullDto);

    Animal mapToEntity(AnimalCreateDto createDto);

}
