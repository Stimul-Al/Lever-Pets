package by.leverx.pets.dto.animal;

import by.leverx.pets.entity.enums.TypeAnimal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aliaksei.babashau
 */
@Data
@Builder
public class AnimalCreateDto {

    @NotBlank
    @ApiModelProperty(example = "Bob", notes = "Name of this animal")
    private String name;

    @NotNull
    @ApiModelProperty(example = "CAT", notes = "Type of this animal")
    private TypeAnimal typeAnimal;
}
