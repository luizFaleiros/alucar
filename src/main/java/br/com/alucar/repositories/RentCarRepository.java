package br.com.alucar.repositories;

import br.com.alucar.domain.entities.BaseEntity;
import br.com.alucar.domain.entities.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentCarRepository extends BaseRepository<RentCar, Long>{
}
