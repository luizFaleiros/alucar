package br.com.alucar.domain.enums;

import lombok.Getter;

@Getter
public enum CarTypeEnum {
     HATCH(1L,"Hatch"),
     SEDAN(2L,"Sedan"),
     CONVERSÍVEL(3L,"Conversível"),
     SUV (4L,"SUV"),
     CROSSOVER(5L,"Crossover"),
     MINIVAN(6L,"Minivan"),
     PICAPEN(7L,"Picapen"),
     WAGON(8L,"Wagon");

    private Long id;
    private String name;

    CarTypeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
