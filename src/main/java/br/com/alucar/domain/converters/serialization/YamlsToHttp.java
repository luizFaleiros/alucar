package br.com.alucar.domain.converters.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;

public final class YamlsToHttp extends AbstractJackson2HttpMessageConverter {

    public YamlsToHttp() {
        super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
    }
}
