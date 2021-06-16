package by.leverx.pets.dto.person;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *
 * @author aliaksei.babashau
 */
@Data
public class PasswordUpdateDto {

    @ApiModelProperty(example = "1", notes = "Id of this person")
    private Long id;

    @ApiModelProperty(example = "qwerty123456", notes = "Password of this person")
    private String password;
}
