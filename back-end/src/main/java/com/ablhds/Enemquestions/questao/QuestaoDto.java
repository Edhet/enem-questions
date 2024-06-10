package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record QuestaoDto(
        Long id,
        @NotNull Integer numeroQuestao,
        @NotBlank String dificuldadeQuestao,
        @NotEmpty List<OpcaoDto> opcoes,
        @NotBlank String enunciado,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String labelOpcaoCorreta
) {
}
