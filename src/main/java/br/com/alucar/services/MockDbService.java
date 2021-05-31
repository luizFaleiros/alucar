package br.com.alucar.services;

import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.entities.RentCar;
import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ColorEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MockDbService {

    private final CarService carService;

    private final RentCarService rentCarService;

    public void instantiateTestDatabase() throws ParseException {
        Car car1 = Car.builder()
                .createdDate(LocalDate.now())
                .modifiedDate(LocalDate.now())
                .modifiedBy("Teste")
                .isDeleted(false)
                .modelo("XYZ")
                .name("GOL")
                .year(2000L)
                .type(CarTypeEnum.MIDDLE)
                .seatsQuantity(12L)
                .portQuantity(4L)
                .color(ColorEnum.RED)
                .shift(ShiftEnum.MANUAL)
                .rentValue(200D)
                .isRented(false)
                .build();

        Car car2 = Car.builder()
                .createdDate(LocalDate.now())
                .modifiedDate(LocalDate.now())
                .modifiedBy("Teste")
                .isDeleted(false)
                .modelo("XYZ")
                .name("CELTA")
                .year(1998L)
                .type(CarTypeEnum.MIDDLE)
                .seatsQuantity(12L)
                .portQuantity(4L)
                .color(ColorEnum.RED)
                .shift(ShiftEnum.MANUAL)
                .rentValue(200D)
                .isRented(false)
                .build();

        Car car3 = Car.builder()
                .createdDate(LocalDate.now())
                .modifiedDate(LocalDate.now())
                .modifiedBy("Teste")
                .isDeleted(false)
                .modelo("XYZ")
                .name("CLIO")
                .year(1999L)
                .type(CarTypeEnum.MIDDLE)
                .seatsQuantity(12L)
                .portQuantity(4L)
                .color(ColorEnum.RED)
                .shift(ShiftEnum.MANUAL)
                .rentValue(200D)
                .isRented(false)
                .build();

        carService.save(car1);
        carService.save(car2);
        carService.save(car3);

        var rentCar = RentCar.builder()
                .createdDate(LocalDate.now())
                .modifiedDate(LocalDate.now())
                .modifiedBy("Teste")
                .isDeleted(false)
                .value(12D)
                .rentDays(10L)
                .initialDate(LocalDateTime.now())
                .finalDate(LocalDateTime.now().plusDays(10))
                .build();
        car1 = carService.findAll().stream().findFirst().get();
        rentCarService.save(rentCar, car1.getId());

    }
}
