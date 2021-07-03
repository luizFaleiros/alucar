package br.com.alucar.domain.dto;

import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ColorEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

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
