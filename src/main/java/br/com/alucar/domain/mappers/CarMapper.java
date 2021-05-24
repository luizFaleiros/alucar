package br.com.alucar.domain.mappers;

import br.com.alucar.domain.dto.responses.CarResponseDTO;
import br.com.alucar.domain.entities.Automovel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponseDTO toResponse(Automovel entity);
}
