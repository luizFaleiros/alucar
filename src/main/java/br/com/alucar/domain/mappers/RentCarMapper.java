package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.entities.RentCar;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RentCarMapper {

    RentCarResponseDTO toResponse(RentCar car);

    @InheritInverseConfiguration
    RentCar toEntity(RentCarDto carDTO);
}
