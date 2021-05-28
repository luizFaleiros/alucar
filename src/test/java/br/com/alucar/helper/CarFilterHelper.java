package br.com.alucar.helper;

import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;

public class CarFilterHelper {

    public static CarFilter carFilter(){

        return  CarFilter.builder()
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
                .type(AutoTypeEnum.MIDDLE)
                .seatsQuantity(Integer.toUnsignedLong(5))
                .portQuantity(Integer.toUnsignedLong(2))
                .color(ColorEnum.WHITE)
                .shift(ShiftEnum.MANUAL)
                .build();

    }
}
