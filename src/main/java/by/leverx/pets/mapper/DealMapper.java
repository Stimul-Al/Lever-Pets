package by.leverx.pets.mapper;

import by.leverx.pets.dto.deal.DealFullDto;
import by.leverx.pets.entity.Deal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealMapper {

    DealMapper DEAL_MAPPER = Mappers.getMapper(DealMapper.class);

    DealFullDto mapToFullDto(Deal deal);
}
