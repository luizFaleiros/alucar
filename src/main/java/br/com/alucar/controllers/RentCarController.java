package br.com.alucar.controllers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.filters.RentCarFilter;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.services.RentCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent-car")
@RequiredArgsConstructor
public class RentCarController implements ControllerBase<RentCarFilter,RentCarDto, RentCarResponseDTO> {
    private final RentCarService rentCarService;

    @Override
    @PostMapping("/list")
    public ResponseEntity<Page<RentCarResponseDTO>> findAll(@RequestBody RentCarFilter carFilter, int size, int page) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RentCarResponseDTO> findById(Long id) {
        return null;
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> save(RentCarDto dto) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(RentCarDto dto, Long id) {
        return null;
    }

    @DeleteMapping("/id")
    @Override
    public ResponseEntity<Void> delete(Long id) {
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }
}
