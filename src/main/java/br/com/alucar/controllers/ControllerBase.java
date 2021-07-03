package br.com.alucar.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ControllerBase<FILTER,
        DTO,
        RESPONSE> {

    ResponseEntity<Page<RESPONSE>> findAll(FILTER carFilter,
                                           int size,
                                           int page);

    ResponseEntity<RESPONSE> findById(Long id);


    ResponseEntity<?> save(DTO dto);


    ResponseEntity<Void> update(DTO dto, Long id);

    ResponseEntity<Void> delete(Long id);

}
