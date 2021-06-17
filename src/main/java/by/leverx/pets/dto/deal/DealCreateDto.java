package by.leverx.pets.dto.deal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DealCreateDto {

    @NotNull
    @JsonProperty("first_animal")
    private Long firstAnimal;

    @NotNull
    @JsonProperty("second_animal")
    private Long secondAnimal;
}
