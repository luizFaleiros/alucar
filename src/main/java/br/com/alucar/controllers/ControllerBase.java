package br.com.alucar.controllers;

import br.com.alucar.domain.dto.BaseDTO;
import br.com.alucar.domain.dto.filters.BaseFilter;
import br.com.alucar.domain.dto.responses.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface ControllerBase<FILTER extends BaseFilter,
        DTO extends BaseDTO,
        RESPONSE extends ResponseDTO> {

    ResponseEntity<Page<RESPONSE>> findAll(FILTER carFilter,
                                           int size,
                                           int page);

    ResponseEntity<RESPONSE> findById(Long id);


    ResponseEntity<Void> save(DTO dto);


    ResponseEntity<Void> update(DTO dto, Long id);

    ResponseEntity<Void> delete(Long id);

}
