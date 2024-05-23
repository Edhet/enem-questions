package com.ablhds.Enemquestions.security;

public record LoginRequestDto(
        String email,
        String senha
) {
}
