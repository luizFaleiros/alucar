package br.com.alucar.domain.dto.responses;

import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDTO  extends RepresentationModel<CarResponseDTO> {
    private Long key;
    private String modelo;
    private String name;
    private Long year;
    private CarTypeEnum type;
    private Long seatsQuantity;
    private Long portQuantity;
    private ColorEnum color;
    private ShiftEnum shift;
    private Double rentValue;
    private Boolean isRented;
}
