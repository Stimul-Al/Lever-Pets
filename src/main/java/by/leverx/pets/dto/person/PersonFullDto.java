package by.leverx.pets.dto.person;

import by.leverx.pets.dto.animal.AnimalFullDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
@Data
public class PersonFullDto {

    @ApiModelProperty(example = "1", notes = "Id of this person")
    private Long id;

    @ApiModelProperty(example = "Bob", notes = "Name of this person")
    private String name;

    @ApiModelProperty(example = "Bob@gmail.com", notes = "Email of this person")
    private String email;

    @ApiModelProperty(example = "qwerty123456", notes = "Password of this person")
    private String password;

    @ApiModelProperty(example = "Animals of this person")
    private List<AnimalFullDto> animals = new ArrayList<>();
}
