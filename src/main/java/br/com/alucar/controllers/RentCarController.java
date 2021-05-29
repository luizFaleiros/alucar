package br.com.alucar.controllers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.filters.RentCarFilter;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.mappers.RentCarMapper;
import br.com.alucar.services.RentCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

    private final RentCarMapper rentCarMapper;

    @Override
    @PostMapping("/list")
    public ResponseEntity<Page<RentCarResponseDTO>> findAll(@RequestBody RentCarFilter carFilter, int size, int page) {
        return ResponseEntity.ok(rentCarService.findAll(carFilter, PageRequest.of(page,size)).map(rentCarMapper::toResponse));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<RentCarResponseDTO> findById(Long id) {
        return ResponseEntity.ok(rentCarMapper.toResponse(rentCarService.findById(id)));
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> save(RentCarDto dto) {
        rentCarService.save(rentCarMapper.toEntity(dto),dto.getCarId());
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(RentCarDto dto, Long id) {
        rentCarService.update(rentCarMapper.toEntity(dto),id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/id")
    @Override
    public ResponseEntity<Void> delete(Long id) {
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }
}
