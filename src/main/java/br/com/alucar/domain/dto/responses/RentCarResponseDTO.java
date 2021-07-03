package br.com.alucar.domain.dto.responses;

import br.com.alucar.domain.dto.CarDTO;
import br.com.alucar.domain.entities.Car;
import io.cucumber.java.mk_latn.No;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentCarResponseDTO {
    private Long id;
    private Double value;
    private Long rentDays;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    private CarDTO car;

}
