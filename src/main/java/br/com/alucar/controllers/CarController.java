package br.com.alucar.controllers;

import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.mappers.CarMapper;
import br.com.alucar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    private final CarMapper carMapper;

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> findAll() {
        return ResponseEntity.ok(carService.findAll().stream().map(carMapper::toResponse).collect(Collectors.toList()));
    }
}
