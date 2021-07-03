package br.com.alucar.domain.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public static ColorEnum getById(Long id) {
        return Arrays.stream(ColorEnum.values())
                .filter(colorEnum -> colorEnum.getId().equals(id))
                .findAny().orElse(null);
    }
}
