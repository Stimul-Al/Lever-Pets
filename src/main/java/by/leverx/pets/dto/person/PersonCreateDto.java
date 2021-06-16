package by.leverx.pets.dto.person;

import by.leverx.pets.dto.animal.AnimalCreateDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aliaksei.babashau
 */
@Data
@Builder
public class PersonCreateDto {

    private static final long MIN_LENGTH = 8;

    @NotBlank
    @ApiModelProperty(example = "Bob", notes = "Name of this person")
    private String name;

    @Email
    @NotBlank
    @ApiModelProperty(example = "Bob@gmail.com", notes = "Email of this person")
    private String email;

    @NotBlank
    @Min(MIN_LENGTH)
    @ApiModelProperty(example = "qwerty123456", notes = "Password of this person")
    private String password;

    @ApiModelProperty(example = "Animals of this person")
    private List<AnimalCreateDto> animals = new ArrayList<>();
}
