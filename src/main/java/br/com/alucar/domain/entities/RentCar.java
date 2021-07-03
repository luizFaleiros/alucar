package br.com.alucar.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "RentCar")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RentCar extends BaseEntity{


    @Column(name = "RENT_VALUE")
    private Double value;

    @Column(name = "RENT_DAYS")
    private Long rentDays;

    @Column(name = "INITIAL_DATE")
    private LocalDateTime initialDate;

    @Column(name = "FINAL_DATE")
    private LocalDateTime finalDate;

    @ManyToOne
    private Car car;

}
