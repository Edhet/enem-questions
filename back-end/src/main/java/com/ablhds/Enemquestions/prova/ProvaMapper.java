package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.Questao;
import com.ablhds.Enemquestions.questao.QuestaoDto;
import com.ablhds.Enemquestions.questao.QuestaoMapper;

import java.time.Year;
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

    public static Prova dtoToEntity(ProvaDto provaDto) {
        AreaProva areaProva = AreaProva.valueOf(provaDto.areaProva());
        // pesquisar para que serve esse metodo
        Year ano = Year.of((int)provaDto.ano());

        List<Questao> questoes = provaDto.questoes()
                .stream()
                .map(QuestaoMapper::dtoToEntity)
                .collect(Collectors.toList());


        Prova prova = new Prova();
        prova.setId(provaDto.id());
        prova.setAreaProva(areaProva);
        prova.setAno(ano);
        prova.setCor(provaDto.cor());
        prova.setQuestoes(questoes);

        return prova;
    }
}
