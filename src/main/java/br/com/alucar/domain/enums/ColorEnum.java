package br.com.alucar.domain.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ColorEnum {
    RED(1L, "VERMELHO"),
    WHITE(2L, "BRANCO"),
    BLACK(3L,"PRETO"),
    GRAY(4L,"CINZA"),
    YELLOW(5L,"AMARELO"),
    BLUE(4L,"AZUL");

    private Long id;
    private String name;

    ColorEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static ColorEnum getById(Long id) {
        return Arrays.stream(ColorEnum.values())
                .filter(colorEnum -> colorEnum.getId().equals(id))
                .findAny().orElse(null);
    }
}
