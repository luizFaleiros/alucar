package br.com.alucar.repositories;

import br.com.alucar.domain.entities.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends BaseRepository<Car, Long> {
}
