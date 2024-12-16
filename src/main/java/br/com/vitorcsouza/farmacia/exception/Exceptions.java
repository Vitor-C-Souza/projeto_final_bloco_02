package br.com.vitorcsouza.farmacia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class Exceptions {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ResponseError> noSuchElementException(NoSuchElementException exception) {
        ResponseError responseError = new ResponseError(
                "Não foi encontrado a categoria do id.",
                HttpStatus.NOT_FOUND,
                LocalDateTime.now()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseError);
    }
}
