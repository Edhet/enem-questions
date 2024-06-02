package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.MetricasDto;
import com.ablhds.Enemquestions.resposta.RespostaDto;

import java.util.List;

public record AplicacaoProvaDto(
        Long id,
        String estadoAplicacaoProva,
        String tempoInicioDeAplicacao,
        String tempoFimDeAplicacao,
        List<RespostaDto> respostas,
        MetricasDto metricas,
        Long idProva
) {
}
