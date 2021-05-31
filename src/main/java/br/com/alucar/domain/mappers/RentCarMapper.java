package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.entities.RentCar;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface RentCarMapper {
    RentCarMapper INSTANCE = Mappers.getMapper(RentCarMapper.class);
    RentCarResponseDTO toResponse(RentCar car);

    @InheritInverseConfiguration
    RentCar toEntity(RentCarDto carDTO);
}
