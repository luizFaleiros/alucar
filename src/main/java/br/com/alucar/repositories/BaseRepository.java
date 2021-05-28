package br.com.alucar.repositories;

import br.com.alucar.domain.entities.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseRepository <T extends BaseEntity, LONG extends Long> extends JpaRepository<T, LONG>, JpaSpecificationExecutor<T> {
}
