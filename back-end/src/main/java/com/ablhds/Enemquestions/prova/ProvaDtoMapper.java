package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.QuestaoDto;
import com.ablhds.Enemquestions.questao.QuestaoDtoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class ProvaDtoMapper {

    public static ProvaDto provaDtoToProvaDto(Prova prova) {
        List<QuestaoDto> questaoDtos = prova.getQuestoes().stream().map(QuestaoDtoMapper::questaoToQuestaoDto).collect(Collectors.toList());
        return new ProvaDto(
                prova.getId(),
                prova.getAreaProva().toString(),
                prova.getAno().getValue(),
                prova.getCor(),
                questaoDtos
        );
    }
    public static Prova provaDtoToProva(ProvaDto provaDto) { // falta fazer
        return null;
    }
}
