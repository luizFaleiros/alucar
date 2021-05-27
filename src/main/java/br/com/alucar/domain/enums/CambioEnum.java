package br.com.alucar.domain.enums;

import lombok.Getter;

@Getter
public enum CambioEnum {
    AUTOMATIC(1L,"Automatico"),
    MANUAL(1L,"Manual");

    private Long id;

    private String type;

    CambioEnum(Long id, String type) {
        this.id = id;
        this.type = type;
    }
}
