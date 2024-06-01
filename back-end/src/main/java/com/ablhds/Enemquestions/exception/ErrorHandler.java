package com.ablhds.Enemquestions.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> customExceptionsHandler(Exception e) {
        String mensagemDeErro = e.getMessage();
        HttpStatus status;

        if (e.getClass().getAnnotation(ResponseStatus.class) == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            mensagemDeErro = "Um erro não especificado ocorreu";
        } else {
            status = e.getClass().getAnnotation(ResponseStatus.class).value();
        }

        ErrorDto errorResponse = new ErrorDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                mensagemDeErro
        );
        return ResponseEntity.status(status.value()).body(errorResponse);
    }
}
