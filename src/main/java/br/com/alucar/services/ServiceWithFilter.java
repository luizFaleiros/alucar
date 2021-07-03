package br.com.alucar.services;

import br.com.alucar.domain.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceWithFilter<T extends BaseEntity, FILTER> extends BaseService<T>{
    Page<T> findAll(FILTER carFilter, Pageable pageable);
}
