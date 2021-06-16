package by.leverx.pets.controller;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import by.leverx.pets.dto.animal.AnimalFullDto;
import by.leverx.pets.dto.animal.AnimalUpdateDto;
import by.leverx.pets.service.AnimalService;
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
@RequestMapping("/animals")
@Api("Controller dedicated to manage animals")
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping("/{id}")
    @ApiOperation("Find one animal by id")
    public AnimalFullDto getById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @GetMapping
    @ApiOperation("Find all animals by id")
    public List<AnimalFullDto> getAll() {
        return animalService.findAll();
    }

    @PostMapping
    @ApiOperation("Create animal")
    public AnimalFullDto create(@Valid @RequestBody AnimalCreateDto createDto) {
        return animalService.create(createDto);
    }

    @PutMapping
    @ApiOperation("Update animal")
    public AnimalFullDto update(@Valid @RequestBody AnimalUpdateDto updateDto) {
        return animalService.update(updateDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete animal by id")
    public void delete(@PathVariable Long id) {
        animalService.delete(id);
    }
}
