package com.ablhds.Enemquestions.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ErrorHandler {
    Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDto> handleAccessDeniedException(AccessDeniedException e) {
        String mensagemDeErro = ErrorMessages.NAO_AUTORIZADO;
        HttpStatus status = HttpStatus.FORBIDDEN;

        return formatarRespostaDeErro(status, mensagemDeErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> jakartaValidationExceptionHandler(MethodArgumentNotValidException e) {
        String mensagemDeErro = ErrorMessages.CADASTRO_CAMPO_INVALIDO.formatted(e.getBindingResult().getFieldError().getField());
        HttpStatus status = HttpStatus.BAD_REQUEST;

        return formatarRespostaDeErro(status, mensagemDeErro);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> customExceptionsHandler(Exception e) {
        String mensagemDeErro = e.getMessage();
        HttpStatus status;

        if (e.getClass().getAnnotation(ResponseStatus.class) == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            mensagemDeErro = "Um erro não especificado ocorreu";
            logger.info("{}: {}", e.getClass().getName(), e.getMessage());
        } else {
            status = e.getClass().getAnnotation(ResponseStatus.class).value();
        }

        return formatarRespostaDeErro(status, mensagemDeErro);
    }

    private ResponseEntity<ErrorDto> formatarRespostaDeErro(HttpStatus status, String mensagemDeErro) {
        ErrorDto errorResponse = new ErrorDto(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                mensagemDeErro
        );
        return ResponseEntity.status(status.value()).body(errorResponse);
    }
}
