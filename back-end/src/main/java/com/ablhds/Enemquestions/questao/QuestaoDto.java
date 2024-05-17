package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.OpcaoDto;

import java.util.List;

public record QuestaoDto(
        long id,
        int numeroQuestao,
        List<OpcaoDto> opcoes,
        String enunciado
) {
}
