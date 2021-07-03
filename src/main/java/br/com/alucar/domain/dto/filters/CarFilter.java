package br.com.alucar.domain.dto.filters;

import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarFilter {

    private String name;

    private Long year;

    private CarTypeEnum type;

    private Long seatsQuantity;

    private Long portQuantity;

    private ColorEnum color;

    private ShiftEnum shift;
}
