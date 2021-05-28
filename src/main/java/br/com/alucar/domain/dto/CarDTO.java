package br.com.alucar.domain.dto;

import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO implements BaseDTO {

    @NotEmpty
    private String modelo;

    @NotEmpty
    private String nome;

    @NotEmpty
    private Long year;

    @NotNull
    private AutoTypeEnum type;

    @NotNull
    private Long seatsQuantity;

    @NotNull
    private Long portQuantity;

    @NotNull
    private ColorEnum color;

    @NotNull
    private ShiftEnum cambio;

    @NotNull
    private Double rentValue;

    @NotNull
    private Boolean isRented;
}
