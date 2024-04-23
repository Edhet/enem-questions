package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.QuestaoDto;

import java.util.List;

public record ProvaDto(
        long id,
        String areaProva,
        long ano,
        String cor,
        List<QuestaoDto> questoes
) {
}
