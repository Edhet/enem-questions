package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.opcao.OpcaoDto;

public record RespostaDto(
        Long id,
        Long idQuestao,
        OpcaoDto opcaoEscolhida
) {
}
