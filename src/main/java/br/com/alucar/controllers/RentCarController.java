package br.com.alucar.controllers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.filters.RentCarFilter;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.entities.RentCar;
import br.com.alucar.domain.mappers.RentCarMapper;
import br.com.alucar.services.RentCarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rent-car")
@RequiredArgsConstructor
public class RentCarController implements ControllerBase<RentCarFilter,RentCarDto, RentCarResponseDTO> {

    private final RentCarService rentCarService;

    private final RentCarMapper rentCarMapper;


    @GetMapping(value = "/list", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<List<RentCarResponseDTO>> findAll() {
        var listCar =rentCarService.findAll().stream().map(rentCarMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(listCar);
    }

    @Override
    public ResponseEntity<Page<RentCarResponseDTO>> findAll(RentCarFilter carFilter, int size, int page) {
        return null;
    }

    @Override
    @GetMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<RentCarResponseDTO> findById(@PathVariable Long id) {
        var rentCar = rentCarMapper.toResponse(rentCarService.findById(id))
                .add(linkTo(methodOn(CarController.class).findById(id)).withSelfRel());
        return ResponseEntity.ok(rentCar);
    }

    @Override
    @PostMapping(value = "/save",produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"} )
    public ResponseEntity<RepresentationModel> save(@RequestBody RentCarDto dto) {
        RentCar rentcar = rentCarService.save(rentCarMapper.toEntity(dto),dto.getCarId());
        var representation =  new RepresentationModel();
        representation
                .add(linkTo(methodOn(RentCarController.class).findById(rentcar.getId()))
                        .withSelfRel())
                .add(linkTo(methodOn(CarController.class).findById(rentcar.getCar().getId())).withSelfRel());
        return ResponseEntity.ok(representation);
    }

    @Override
    @PutMapping(value = "/{id}", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Void> update(RentCarDto dto, Long id) {
        rentCarService.update(rentCarMapper.toEntity(dto),id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping(value = "/delete/{id}", consumes = {"application/json", "application/xml", "application/x-yaml"})
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rentCarService.delete(id);
        return ResponseEntity.ok().build();
    }
}
