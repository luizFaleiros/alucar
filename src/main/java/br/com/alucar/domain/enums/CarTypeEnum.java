package br.com.alucar.domain.enums;

import lombok.Getter;

@Getter
public enum CarTypeEnum {
    MIDDLE(1L,"Médio"),
    VAN(2L,"Van"),
    TRUCK(3L,"Caminhão");

    private Long id;
    private String name;

    CarTypeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
