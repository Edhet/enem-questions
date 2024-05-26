package com.ablhds.Enemquestions.security;

public record CadastroRequestDto(
        String nome,
        String email,
        String senha
) {
}
