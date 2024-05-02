package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.questao.QuestaoDto;

public record RespostaDto(
        long id,
        QuestaoDto questao,
        OpcaoDto opcaoEscolhida,
        AplicacaoProvaDto aplicacaoProvaDto
) {
}
