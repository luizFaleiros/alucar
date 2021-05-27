package br.com.alucar.domain.enums;

import lombok.Getter;

@Getter
public enum ColorEnum {
    RED(1L, "VERMELHO"),
    WHITE(2L, "BRANCO"),
    BLACK(3L,"PRETO");

    private Long id;
    private String name;

    ColorEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
