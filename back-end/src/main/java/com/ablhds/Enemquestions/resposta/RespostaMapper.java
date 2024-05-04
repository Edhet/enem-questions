package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.opcao.OpcaoMapper;

public final class RespostaMapper {
    public static RespostaDto entityToDto(Resposta resposta) {
        OpcaoDto opcaoDto = OpcaoMapper.entityToDto(resposta.getOpcaoEscolhida());

        return new RespostaDto(
                resposta.getId(),
                resposta.getQuestao().getId(),
                opcaoDto
        );
    }

    public static Resposta dtoToEntity(RespostaDto respostaDto) {
        Opcao opcao = OpcaoMapper.dtoToEntity(respostaDto.opcaoEscolhida());

        return new Resposta(
                respostaDto.id(),
                null,
                opcao,
                null
        );
    }
}
