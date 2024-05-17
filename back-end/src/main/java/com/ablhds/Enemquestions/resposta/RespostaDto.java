package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.opcao.OpcaoDto;

public record RespostaDto(
        long id,
        long idQuestao,
        OpcaoDto opcaoEscolhida
) {
}
