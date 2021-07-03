package br.com.alucar.helper;

import br.com.alucar.domain.entities.RentCar;

import java.time.LocalDateTime;

public class RentCarHelper {

    public static RentCar montRentCar() {
        return RentCar.builder()
                .value(1500D)
                .rentDays(12L)
                .initialDate(LocalDateTime.now())
                .finalDate(LocalDateTime.now().plusDays(12))
                .car(CarHelper.rentedCar())
                .build();
    }
}
