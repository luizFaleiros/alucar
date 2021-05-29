package br.com.alucar.domain.dto.responses;

import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponseDTO implements ResponseDTO{

    private Long id;

    private String modelo;

    private String nome;

    private Long year;

    private CarTypeEnum type;

    private Long seatsQuantity;

    private Long portQuantity;

    private ColorEnum color;

    private ShiftEnum cambio;

    private Double rentValue;

    private Boolean isRented;
}
