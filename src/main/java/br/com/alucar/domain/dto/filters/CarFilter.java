package br.com.alucar.domain.dto.filters;

import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.CambioEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarFilter {

    private String name;

    private Long year;

    private AutoTypeEnum type;

    private Long seatsQuantity;

    private Long portQuantity;

    private ColorEnum color;

    private CambioEnum shift;
}
