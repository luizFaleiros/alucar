package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.RentCarDto;
import br.com.alucar.domain.dto.responses.RentCarResponseDTO;
import br.com.alucar.domain.entities.RentCar;

public interface RentCarMapper {

    RentCarResponseDTO toResponse(RentCar car);

    RentCar toEntity(RentCarDto carDTO);
}
