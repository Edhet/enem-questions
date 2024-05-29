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
        HttpStatus status = e.getClass().getAnnotation(ResponseStatus.class).value();

        ErrorDto errorResponse = new ErrorDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                e.getMessage()
        );
        return ResponseEntity.status(status.value()).body(errorResponse);
    }
}
