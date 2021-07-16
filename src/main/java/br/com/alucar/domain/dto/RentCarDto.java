package br.com.alucar.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentCarDto {

    @ApiModelProperty(required = true,example = "2018-10-01 12:18:48")
    @NotNull(message = "É necessario o dia inicial")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime initialDate;

    @ApiModelProperty(required = true,example = "2018-10-01 12:18:48")
    @NotNull(message = "É necessario o dia final")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime finalDate;

    @NotNull(message = "É necessario o id do carro")
    private Long carId;
}
