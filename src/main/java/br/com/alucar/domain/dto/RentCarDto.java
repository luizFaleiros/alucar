package br.com.alucar.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentCarDto {

    @NotNull(message = "É necessario o dia inicial")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime initialDate;

    @NotNull(message = "É necessario o dia final")
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private LocalDateTime finalDate;

    @NotNull(message = "É necessario o id do carro")
    private Long carId;
}
