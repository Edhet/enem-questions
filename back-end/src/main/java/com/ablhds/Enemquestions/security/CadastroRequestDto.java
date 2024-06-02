package com.ablhds.Enemquestions.security;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CadastroRequestDto(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha
) {
}
