package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.QuestaoDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProvaDto(
        Long id,
        @NotBlank String nome,
        @NotBlank String areaProva,
        @NotBlank String diaDeProva,
        @NotNull Long ano,
        @NotBlank String cor,
        @NotEmpty List<QuestaoDto> questoes
) {
}
