package by.leverx.pets.controller;

import by.leverx.pets.dto.deal.DealCreateDto;
import by.leverx.pets.dto.deal.DealFullDto;
import by.leverx.pets.service.DealService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/deals")
@RequiredArgsConstructor
@ApiOperation("Controller dedicated to manage deals")
public class DealController {

    private final DealService dealService;

    @PostMapping
    public DealFullDto deal(@Valid @RequestBody DealCreateDto dealCreateDto) {
        return dealService.deal(dealCreateDto);
    }
}
