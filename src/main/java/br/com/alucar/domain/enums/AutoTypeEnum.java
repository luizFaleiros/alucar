package br.com.alucar.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.yaml.snakeyaml.events.Event;

@Getter
public enum AutoTypeEnum {
    MIDDLE(1L,"Médio"),
    VAN(2L,"Van"),
    TRUCK(3L,"Caminhão");

    private Long id;
    private String name;

    AutoTypeEnum(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
