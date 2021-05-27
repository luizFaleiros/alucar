package br.com.alucar.helper;

import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.CambioEnum;
import br.com.alucar.domain.enums.ColorEnum;

public class CarHelper {

    public static Car validCar(){
        return Car.builder()
                .modelo("XYZ")
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
                .type(AutoTypeEnum.MIDDLE)
                .seatsQuantity(Integer.toUnsignedLong(5))
                .portQuantity(Integer.toUnsignedLong(2))
                .color(ColorEnum.WHITE)
                .shift(CambioEnum.MANUAL)
                .isDeleted(false)
                .isRented(false)
                .build();

    }


    public static Car rentedCar(){
        return Car.builder()
                .modelo("XYZ")
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
                .type(AutoTypeEnum.MIDDLE)
                .seatsQuantity(Integer.toUnsignedLong(5))
                .portQuantity(Integer.toUnsignedLong(2))
                .color(ColorEnum.WHITE)
                .shift(CambioEnum.MANUAL)
                .isDeleted(false)
                .isRented(true)
                .build();

    }
}