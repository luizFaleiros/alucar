package br.com.alucar.controllers;

import br.com.alucar.domain.dto.CarDTO;
import br.com.alucar.domain.dto.filters.CarFilter;
import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.entities.Car;
import br.com.alucar.domain.enums.ColorEnum;
import br.com.alucar.domain.mappers.CarMapper;
import br.com.alucar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController implements ControllerBase<CarFilter,CarDTO,CarResponseDTO>{

    private final CarService carService;

    private final CarMapper carMapper;

    @PostMapping(value = "/list",
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<Page<CarResponseDTO>> findAll(@RequestBody CarFilter carFilter,
                                                        @RequestParam(name = "size", defaultValue = "1" )int size,
                                                        @RequestParam(name = "page", defaultValue = "0" )int page) {
        return ResponseEntity.ok(carService.findAll(carFilter, PageRequest.of(page,size))
                .map(carMapper::toResponse));
    }

    @GetMapping(value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<CarResponseDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(carMapper.toResponse(carService.findById(id)));
    }

    @PostMapping(value="/save",
            produces = {"application/json", "application/xml", "application/x-yaml"},
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<RepresentationModel> save(@RequestBody CarDTO carDTO){
        Car car = carService.save(carMapper.toEntity(carDTO));
        var representation =  new RepresentationModel();
        representation
                .add(linkTo(methodOn(CarController.class).findById(car.getId()))
                        .withSelfRel());
        return ResponseEntity.ok(representation);
    }

    @PutMapping(value = "/update/{id}",
            consumes = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<Void> update(@RequestBody CarDTO carDTO, @PathVariable Long id){
        carService.update(carMapper.toEntity(carDTO), id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        carService.logicalDelete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value= "/colors", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<ColorEnum>> colors(){
        return ResponseEntity.ok(Arrays.asList(ColorEnum.values()));
    }

}
