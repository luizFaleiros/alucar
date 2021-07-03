package br.com.alucar.services;

import br.com.alucar.domain.dto.filters.RentCarFilter;
import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.entities.RentCar;
import br.com.alucar.exceptions.RentCarNotFoundException;
import br.com.alucar.repositories.RentCarRepository;
import br.com.alucar.repositories.specification.RentCarSpecification;
import lombok.RequiredArgsConstructor;
import org.joda.time.Period;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentCarService implements ServiceWithFilter<RentCar, RentCarFilter> {

    private final RentCarRepository rentCarRepository;

    private final CarService carService;

    @Override
    public List<RentCar> findAll() {
        return rentCarRepository.findAll();
    }

    @Override
    public RentCar findById(Long id) {
        return rentCarRepository.findById(id).orElseThrow(RentCarNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        RentCar rentCar = findById(id);
        Car car = rentCar.getCar();
        car.setIsRented(false);
        carService.save(car);
        rentCarRepository.delete(rentCar);

    }

    @Override
    public void logicalDelete(Long id) {
        RentCar rentCar = findById(id);
        rentCar.setIsDeleted(true);
        rentCarRepository.save(rentCar);
    }

    @Override
    public RentCar save(RentCar entity) {
        return null;
    }

    public RentCar save(RentCar entity, Long carId) {
        entity.setRentDays(calculateRentDays(entity.getInitialDate(), entity.getFinalDate()));
        Car car = carService.findById(carId);
        car.setIsRented(true);
        entity.setCar(car);
        entity.setValue(entity.getRentDays() * car.getRentValue());
        entity.setCreatedDate(LocalDate.now());
        entity.setModifiedBy("Teste");
        entity.setModifiedDate(LocalDate.now());
        entity.setIsDeleted(false);
        return rentCarRepository.save(entity);
    }

    private Long calculateRentDays(LocalDateTime initialDate, LocalDateTime finalDate) {
        if(initialDate.isAfter(finalDate)){
            throw new RuntimeException();
        }

        return  initialDate.until(finalDate, ChronoUnit.DAYS);
    }

    @Override
    public RentCar update(RentCar entity, Long id) {
        RentCar rentCar = findById(id);
        rentCar.setValue(entity.getValue());
        rentCar.setRentDays(entity.getRentDays());
        rentCar.setInitialDate(entity.getInitialDate());
        rentCar.setFinalDate(entity.getFinalDate());
        rentCar.setCar(entity.getCar());
        return rentCarRepository.save(rentCar);
    }

    @Override
    public Page<RentCar> findAll(RentCarFilter carFilter, Pageable pageable) {
        return rentCarRepository.findAll(new RentCarSpecification(carFilter), pageable);
    }
}
