package br.com.alucar.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentCarDto implements BaseDTO {
    private Long rentDays;
    private LocalDateTime initialDate;
    private LocalDateTime finalDate;
    private Long carId;
}
