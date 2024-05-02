package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.opcao.OpcaoMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class QuestaoMapper {

    public static QuestaoDto entityToDto(Questao questao) {
        List<OpcaoDto> opcaoDtos = questao.getOpcoes()
                .stream()
                .map(OpcaoMapper::entityToDto)
                .collect(Collectors.toList());

        return new QuestaoDto(
                questao.getId(),
                questao.getNumeroQuestao(),
                opcaoDtos // passar essa lista de opcoes para opcoes dto
        );
    }

    public static Questao dtoToEntity(QuestaoDto questaoDto) {

        List<Opcao> opcoes = questaoDto.opcoes()
                .stream()
                .map(OpcaoMapper::dtoToEntity)
                .collect(Collectors.toList());

        Questao questao = new Questao();
        questao.setId(questaoDto.id());
        questao.setNumeroQuestao(questaoDto.numeroQuestao());
        questao.setOpcoes(opcoes);

        return questao;
    }
}
