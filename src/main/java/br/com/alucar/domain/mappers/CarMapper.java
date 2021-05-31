package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.CarDTO;
import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.entities.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    CarResponseDTO toResponse(Car car);

    @InheritInverseConfiguration
    Car toEntity(CarDTO carDTO);
}
