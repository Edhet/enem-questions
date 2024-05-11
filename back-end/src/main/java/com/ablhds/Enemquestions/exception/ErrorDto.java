package com.ablhds.Enemquestions.exception;

import java.time.LocalDateTime;

public record ErrorDto(
        Integer status,
        String error,
        String mensagem,
        LocalDateTime timestamp
) {
}
