package br.com.alucar.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RentCarNotFoundException extends RuntimeException {
    public RentCarNotFoundException() {
        super("Aluguel de automovel não encontrado");
    }
}
