package by.leverx.pets.dto.deal;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class DealFullDto {

    private Long id;
    private Long firstAnimalId;
    private Long secondAnimalId;
    private LocalDateTime dealDate;
}
