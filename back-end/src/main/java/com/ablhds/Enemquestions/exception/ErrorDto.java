package com.ablhds.Enemquestions.exception;

import java.time.LocalDateTime;

public record ErrorDto(
        LocalDateTime timestamp,
        Integer status,
        String error,
        String mensagem
) {
}
