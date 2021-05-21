package br.com.alucar.exceptions.handler;

import br.com.alucar.exceptions.AutomovelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AutomovelNotFoundException.class)
    public final ResponseEntity<StandartError> handlePersonNotFound(AutomovelNotFoundException ex, WebRequest request){

        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

}
