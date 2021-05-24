package br.com.alucar.services;

import br.com.alucar.domain.entities.Car;
import br.com.alucar.exceptions.AutomovelNotFoundException;
import br.com.alucar.repositories.AutomoveisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements BaseService<Car> {

    private final AutomoveisRepository automoveisRepository;

    @Override
    public List<Car> findAll() {
        return automoveisRepository.findAll();
    }

    @Override
    public Car findById(Long id) {
        return automoveisRepository.findById(id).orElseThrow(() -> new AutomovelNotFoundException());
    }

    @Override
    public void delete(Long id) {
        Car car = findById(id);
        automoveisRepository.delete(car);
    }

    @Override
    public void logicalDelete(Long id) {
        Car car = findById(id);
        car.setIsDeleted(true);
        save(car);
    }

    @Override
    public void save(Car car) {
        automoveisRepository.save(car);
    }

    @Override
    public Car update(Car entity, Long id) {
        Car bdEntity = findById(id);
        bdEntity.setModelo(entity.getModelo());
        bdEntity.setNome(entity.getNome());
        bdEntity.setAno(entity.getAno());
        bdEntity.setType(entity.getType());
        bdEntity.setSeatsQuantity(entity.getSeatsQuantity());
        bdEntity.setPortQuantity(entity.getPortQuantity());
        bdEntity.setColor(entity.getColor());
        bdEntity.setCambio(entity.getCambio());
        return automoveisRepository.save(bdEntity);
    }

}
