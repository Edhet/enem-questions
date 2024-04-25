package com.ablhds.Enemquestions.resposta;

import org.springframework.stereotype.Service;

@Service
public final class RespostaDtoMapper  {

    public static RespostaDto respostaToRespostaDto(Resposta resposta) {
        return new RespostaDto(
                resposta.getId(),
                resposta.getQuestao().getId(),
                resposta.getOpcaoEscolhida().getId(),
                resposta.getAplicacaoProva().getId()
        ) ;
    }
    public static Resposta respostaDtoToResposta (RespostaDto respostaDto) {
        return null;
    }

}
