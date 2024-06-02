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
                questao.getDificuldadeQuestao().toString(),
                opcaoDtos,
                questao.getEnunciado(),
                null
        );
    }

    public static Questao dtoToEntity(QuestaoDto questaoDto) {
        DificuldadeQuestao dificuldadeQuestao = DificuldadeQuestao.valueOf(questaoDto.dificuldadeQuestao());

        List<Opcao> opcoes = questaoDto.opcoes()
                .stream()
                .map(OpcaoMapper::dtoToEntity)
                .collect(Collectors.toList());

        Opcao opcaoCorreta = opcoes.stream()
                .filter(opcao -> opcao.getLabel().equals(questaoDto.opcaoCorreta().label()))
                .toList()
                .getFirst();

        return new Questao(
                questaoDto.id(),
                dificuldadeQuestao,
                questaoDto.numeroQuestao(),
                null,
                questaoDto.enunciado(),
                opcoes,
                opcaoCorreta
        );
    }
}
