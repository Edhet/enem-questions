package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.QuestaoDto;
import com.ablhds.Enemquestions.questao.QuestaoMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class ProvaMapper {

    public static ProvaDto entityToDto(Prova prova) {
        List<QuestaoDto> questaoDtos = prova.getQuestoes().stream().map(QuestaoMapper::entityToDto).collect(Collectors.toList());
        return new ProvaDto(
                prova.getId(),
                prova.getAreaProva().toString(),
                prova.getAno().getValue(),
                prova.getCor(),
                questaoDtos
        );
    }

    public static Prova dtoToEntity(ProvaDto provaDto) { // falta fazer
        return null;
    }
}
