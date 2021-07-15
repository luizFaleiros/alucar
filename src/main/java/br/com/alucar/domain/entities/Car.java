package br.com.alucar.domain.entities;

import br.com.alucar.domain.enums.CarTypeEnum;
import br.com.alucar.domain.enums.ShiftEnum;
import br.com.alucar.domain.enums.ColorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Car extends BaseEntity {

    @Column(name = "MODEL")
    private String model;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR")
    private Long year;

    @Column(name = "TYPE")
    private CarTypeEnum type;

    @Column(name = "SEATS_QUANTITY")
    private Long seatsQuantity;

    @Column(name = "PORT_QUANTITY")
    private Long portQuantity;

    @Column(name = "COLOR")
    private ColorEnum color;

    @Column(name = "SHIFT")
    private ShiftEnum shift;

    @Column(name = "RENT_VALUE")
    private Double rentValue;

    @Column(name = "IS_RENTED")
    private Boolean isRented = false;

}
