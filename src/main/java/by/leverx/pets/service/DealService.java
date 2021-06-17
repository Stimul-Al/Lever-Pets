package by.leverx.pets.service;

import by.leverx.pets.dto.deal.DealCreateDto;
import by.leverx.pets.dto.deal.DealFullDto;

public interface DealService {

    DealFullDto deal(DealCreateDto createDto);
}
