package com.ablhds.Enemquestions.opcao;

import jakarta.validation.constraints.NotBlank;

public record OpcaoDto(
        Long id,
        @NotBlank String label,
        @NotBlank String texto
) {
}
