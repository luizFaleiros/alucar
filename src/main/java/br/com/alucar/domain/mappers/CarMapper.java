package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.CarDTO;
import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.entities.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponseDTO toResponse(Car car);

    @InheritInverseConfiguration
    Car toEntity(CarDTO carDTO);
}
