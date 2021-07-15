package br.com.alucar.helper;

import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;

public class CarHelper {

    public static Car validCar(){
        return Car.builder()
                .model("XYZ")
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
                .type(CarTypeEnum.HATCH)
                .seatsQuantity(Integer.toUnsignedLong(5))
                .portQuantity(Integer.toUnsignedLong(2))
                .color(ColorEnum.WHITE)
                .shift(ShiftEnum.MANUAL)
                .rentValue(5D)
                .isDeleted(false)
                .isRented(false)
                .build();

    }


    public static Car rentedCar(){
        return Car.builder()
                .model("XYZ")
                .name("Gol")
                .year(Integer.toUnsignedLong(1983))
                .type(CarTypeEnum.HATCH)
                .seatsQuantity(Integer.toUnsignedLong(5))
                .portQuantity(Integer.toUnsignedLong(2))
                .color(ColorEnum.WHITE)
                .shift(ShiftEnum.MANUAL)
                .isDeleted(false)
                .isRented(true)
                .build();
    }
}
