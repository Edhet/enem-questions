package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.MetricasDto;
import com.ablhds.Enemquestions.resposta.RespostaDto;

import java.util.List;

public record AplicacaoProvaDto(
        long id,
        String estadoAplicacaoProva,
        String tempoInicioDeAplicacao,
        String tempoFimDeAplicacao,
        List<RespostaDto> respostas,
        MetricasDto metricas,
        long idProva
) {
}
