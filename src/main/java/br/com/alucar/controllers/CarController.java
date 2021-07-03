package br.com.alucar.controllers;

import br.com.alucar.domain.dto.CarDTO;
import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.mappers.CarMapper;
import br.com.alucar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController implements ControllerBase<CarFilter,CarDTO,CarResponseDTO>{

    private final CarService carService;

    private final CarMapper carMapper;

    @PostMapping("/list")
    @Override
    public ResponseEntity<Page<CarResponseDTO>> findAll(@RequestBody CarFilter carFilter,
                                                        @RequestParam(name = "size", defaultValue = "1" )int size,
                                                        @RequestParam(name = "page", defaultValue = "0" )int page) {
        return ResponseEntity.ok(carService.findAll(carFilter, PageRequest.of(page,size)).map(carMapper::toResponse));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CarResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(carMapper.toResponse(carService.findById(id)));
    }

    @PostMapping
    @Override
    public ResponseEntity<Void> save(@RequestBody CarDTO carDTO){
        carService.save(carMapper.toEntity(carDTO));
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Void> update(@RequestBody CarDTO carDTO, @PathVariable Long id){
        carService.update(carMapper.toEntity(carDTO), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.logicalDelete(id);
        return ResponseEntity.ok().build();
    }

}
