package by.leverx.pets.controller;

import by.leverx.pets.dto.deal.DealDto;
import by.leverx.pets.service.DealService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author aliaksei.babashau
 */
@RestController
@RequestMapping("/deals")
@RequiredArgsConstructor
@ApiOperation("Controller dedicated to manage deals")
public class DealController {

    private final DealService dealService;

    @PostMapping
    public void deal(@Valid @RequestBody DealDto dealDto) {
        dealService.deal(dealDto);
    }
}
