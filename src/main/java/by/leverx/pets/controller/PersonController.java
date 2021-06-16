package by.leverx.pets.controller;

import by.leverx.pets.dto.person.PersonCreateDto;
import by.leverx.pets.dto.person.PersonFullDto;
import by.leverx.pets.dto.person.PersonPreviewDto;
import by.leverx.pets.dto.person.PersonUpdateDto;
import by.leverx.pets.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
@Api("Controller dedicated to manage persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    @ApiOperation("Find one person by id")
    public PersonFullDto getById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @GetMapping
    @ApiOperation("Find all persons")
    public List<PersonPreviewDto> findAll() {
        return personService.findAll();
    }

    @PostMapping
    @ApiOperation("Create person")
    public PersonFullDto create(@Valid @RequestBody PersonCreateDto createDto) {
        return personService.create(createDto);
    }

    @PutMapping
    @ApiOperation("Update animal")
    public PersonFullDto update(@Valid @RequestBody PersonUpdateDto updateDto) {
        return personService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete person")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }
}
