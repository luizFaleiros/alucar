package br.com.alucar.repositories;

import br.com.alucar.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutomoveisRepository extends JpaRepository<Car, Long> {
}
