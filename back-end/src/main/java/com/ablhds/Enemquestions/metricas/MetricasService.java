package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;

@Service
@Transactional
@AllArgsConstructor
public class MetricasService {
    public void calcularMetricasAplicacaoProva(AplicacaoProva aplicacaoProva) {
        Metricas metricas = aplicacaoProva.getMetricas();
        metricas.setSegundosTotaisDeProva(calcularSegundosTotais(aplicacaoProva));
        metricas.setSegundosMediosPorQuestao(calcularTempoMedioQuestao(aplicacaoProva));
        metricas.setQuantidadeDeAcertos(calcularNumeroAcertos(aplicacaoProva));
    }

    private long calcularSegundosTotais(AplicacaoProva aplicacaoProva) {
        return aplicacaoProva.getTempoFimDeAplicacao().toEpochSecond(ZoneOffset.UTC) - aplicacaoProva.getTempoInicioDeAplicacao().toEpochSecond(ZoneOffset.UTC);
    }

    private long calcularTempoMedioQuestao(AplicacaoProva aplicacaoProva) {
        return calcularSegundosTotais(aplicacaoProva) / aplicacaoProva.getProva().getQuestoes().size();
    }

    private long calcularNumeroAcertos(AplicacaoProva aplicacaoProva) {
        long respostasCertas = 0;
        for (var resposta : aplicacaoProva.getRespostas()) {
            if (resposta.reaspostaCorreta()) respostasCertas++;
        }
        return respostasCertas;
    }
}
