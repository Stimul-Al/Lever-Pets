package by.leverx.pets.dto.animal;

import by.leverx.pets.entity.enums.TypeAnimal;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author aliaksei.babashau
 */
@Data
public class AnimalFullDto {

    @ApiModelProperty(example = "1", notes = "Id of this animal")
    private Long id;

    @ApiModelProperty(example = "Bob", notes = "Name of this animal")
    private String name;

    @ApiModelProperty(example = "1", notes = "Id of owner this animal")
    private Long personId;

    @ApiModelProperty(example = "CAT", notes = "Type of this animal")
    private TypeAnimal typeAnimal;
}
