package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.opcao.OpcaoDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class QuestaoDtoMapper {

    public static QuestaoDto questaoToQuestaoDto(Questao questao) {
        List<OpcaoDto> opcaoDtos = questao.getOpcoes()
                .stream()
                .map(OpcaoDtoMapper::opcaoToOpcaoDto)
                .collect(Collectors.toList());

        return new QuestaoDto(
                questao.getId(),
                questao.getNumeroQuestao(),
                opcaoDtos // passar essa lista de opcoes para opcoes dto
        );
    }
    public static Questao questaoDtoToQuestao(QuestaoDto questaoDto) {
        return null;
    }
}
