package br.com.alucar.exceptions.handler;

import br.com.alucar.exceptions.CarNotFoundException;
import br.com.alucar.exceptions.RentCarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarNotFoundException.class)
    public final ResponseEntity<StandartError> handleCarNotFound(CarNotFoundException ex, WebRequest request){

        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

    @ExceptionHandler(RentCarNotFoundException.class)
    public final ResponseEntity<StandartError> handleRentCarNotFound(RentCarNotFoundException ex, WebRequest request){

        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);

    }

}
