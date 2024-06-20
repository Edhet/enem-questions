package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.Questao;
import com.ablhds.Enemquestions.questao.QuestaoDto;
import com.ablhds.Enemquestions.questao.QuestaoMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class ProvaMapper {
    public static ProvaDto entityToDto(Prova prova) {
        List<QuestaoDto> questaoDtos = prova.getQuestoes().stream().map(QuestaoMapper::entityToDto).toList();
        return new ProvaDto(
                prova.getId(),
                prova.getNome(),
                prova.getAreaProva().toString(),
                prova.getDiaDeProva().toString(),
                prova.getAno(),
                prova.getCor(),
                questaoDtos
        );
    }

    public static Prova dtoToEntity(ProvaDto provaDto) {
        AreaProva areaProva = AreaProva.valueOf(provaDto.areaProva());
        DiaDeProva diaDeProva = DiaDeProva.valueOf(provaDto.diaDeProva());

        List<Questao> questoes = provaDto.questoes()
                .stream()
                .map(QuestaoMapper::dtoToEntity)
                .collect(Collectors.toList());

        return new Prova(
                provaDto.id(),
                provaDto.nome(),
                areaProva,
                diaDeProva,
                provaDto.ano(),
                provaDto.cor(),
                null,
                questoes
        );
    }
}
