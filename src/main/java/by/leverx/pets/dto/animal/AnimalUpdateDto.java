package by.leverx.pets.dto.animal;

import by.leverx.pets.entity.enums.TypeAnimal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author aliaksei.babashau
 */
@Data
public class AnimalUpdateDto {

    @ApiModelProperty(example = "1", notes = "Id of this animal")
    private Long id;

    @NotBlank
    @ApiModelProperty(example = "Bob", notes = "Name of this animal")
    private String name;

    @NotNull
    @ApiModelProperty(example = "CAT", notes = "Type of this animal")
    private TypeAnimal typeAnimal;
}
