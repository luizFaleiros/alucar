package br.com.alucar.controllers;

import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.mappers.CarMapper;
import br.com.alucar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    private final CarMapper carMapper;

    @PostMapping
    public ResponseEntity<Page<CarResponseDTO>> findAll(@RequestBody CarFilter carFilter,
                                                        @RequestParam(name = "size", defaultValue = "1" )int size,
                                                        @RequestParam(name = "page", defaultValue = "0" )int page) {
        return ResponseEntity.ok(carService.findAll(carFilter, PageRequest.of(page,size)).map(carMapper::toResponse));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(carMapper.toResponse(carService.findById(id)));
    }
}
