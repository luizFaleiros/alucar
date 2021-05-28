package br.com.alucar.services;

import br.com.alucar.domain.dto.filters.BaseFilter;
import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.entities.BaseEntity;
import br.com.alucar.domain.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceWithFilter<T extends BaseEntity, FILTER extends BaseFilter> extends BaseService<T>{
    Page<T> findAll(FILTER carFilter, Pageable pageable);
}
