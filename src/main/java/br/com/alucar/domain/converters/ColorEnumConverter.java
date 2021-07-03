package br.com.alucar.domain.converters;

import br.com.alucar.domain.enums.ColorEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ColorEnumConverter implements AttributeConverter<ColorEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(ColorEnum colorEnum) {
        return colorEnum.getId();
    }

    @Override
    public ColorEnum convertToEntityAttribute(Long id) {
        return ColorEnum.getById(id);
    }
}
