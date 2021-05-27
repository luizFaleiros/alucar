package br.com.alucar.domain.entities;

import br.com.alucar.domain.enums.AutoTypeEnum;
import br.com.alucar.domain.enums.CambioEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Car extends BaseEntity {

    @Column(name = "MODEL")
    private String modelo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private Long year;

    @Column(name = "TYPE")
    private AutoTypeEnum type;

    @Column(name = "SEATS_QUANTITY")
    private Long seatsQuantity;

    @Column(name = "PORT_QUANTITY")
    private Long portQuantity;

    @Column(name = "COLOR")
    private ColorEnum color;

    @Column(name = "SHIFT")
    private CambioEnum shift;

    @Column(name = "RENT_VALUE")
    private Double rentValue;


    @Column(name = "IS_RENTED")
    private Boolean isRented = false;

}
