package by.leverx.pets.dto.person;

import by.leverx.pets.dto.animal.AnimalFullDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
@Data
public class PersonUpdateDto {

    @ApiModelProperty(example = "1", notes = "Id of this person")
    private Long id;

    @NotBlank
    @ApiModelProperty(example = "Bob", notes = "Name of this person")
    private String name;

    @ApiModelProperty(example = "Animals of this person")
    private List<AnimalFullDto> animals = new ArrayList<>();
}
