package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.entities.RentCar;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface RentCarMapper {
    RentCarMapper INSTANCE = Mappers.getMapper(RentCarMapper.class);

    @Mapping(source = "id", target = "id")
    RentCarResponseDTO toResponse(RentCar car);

    @InheritInverseConfiguration
    @Mapping(source = "carId", target = "car.id")
    RentCar toEntity(RentCarDto carDTO);
}
