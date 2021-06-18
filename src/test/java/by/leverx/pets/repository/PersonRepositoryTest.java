package by.leverx.pets.repository;

import by.leverx.pets.integration.AbstractIntegrationTest;
import by.leverx.pets.mapper.PersonMapper;
import by.leverx.pets.utils.UtilDto;
import lombok.var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static by.leverx.pets.mapper.PersonMapper.PERSON_MAPPER;
import static by.leverx.pets.utils.UtilDto.getPersonCreateDto;

public class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void createTest() {
        //given
        var personToSave = PERSON_MAPPER.mapToEntity(getPersonCreateDto());

        //when
        personRepository.save(personToSave);

        //then
        Assertions.assertNotNull(personToSave.getId());
    }
}
