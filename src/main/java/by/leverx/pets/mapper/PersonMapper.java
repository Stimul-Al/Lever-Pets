package by.leverx.pets.mapper;

import by.leverx.pets.dto.person.PersonCreateDto;
import by.leverx.pets.dto.person.PersonFullDto;
import by.leverx.pets.dto.person.PersonPreviewDto;
import by.leverx.pets.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author aliaksei.babashau
 */
@Mapper(uses = AnimalMapper.class)
public interface PersonMapper {

    PersonMapper PERSON_MAPPER = Mappers.getMapper(PersonMapper.class);

    PersonFullDto mapToDto(Person person);

    PersonPreviewDto mapToPreviewDto(Person person);

    Person mapToEntity(PersonCreateDto createDto);
}
