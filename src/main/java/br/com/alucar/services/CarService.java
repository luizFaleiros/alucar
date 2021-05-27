package br.com.alucar.services;

import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.entities.Car;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.repositories.CarRepository;
import br.com.alucar.repositories.specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements BaseService<Car> {

    private final CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Page<Car> findAll(CarFilter carFilter, Pageable pageable) {
        return carRepository.findAll(new CarSpecification(carFilter), pageable);
    }

    @Override
    public Car findById(Long id) {
        return carRepository.findById(id).orElseThrow(() -> new AutomovelNotFoundException());
    }

    @Override
    public void delete(Long id) {
        Car car = findById(id);
        carRepository.delete(car);
    }

    @Override
    public void logicalDelete(Long id) {
        Car car = findById(id);
        car.setIsDeleted(true);
        save(car);
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car update(Car entity, Long id) {
        Car bdEntity = findById(id);
        bdEntity.setModelo(entity.getModelo());
        bdEntity.setName(entity.getName());
        bdEntity.setYear(entity.getYear());
        bdEntity.setType(entity.getType());
        bdEntity.setSeatsQuantity(entity.getSeatsQuantity());
        bdEntity.setPortQuantity(entity.getPortQuantity());
        bdEntity.setColor(entity.getColor());
        bdEntity.setShift(entity.getShift());
        return carRepository.save(bdEntity);
    }

}
