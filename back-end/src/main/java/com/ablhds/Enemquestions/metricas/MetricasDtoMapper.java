package com.ablhds.Enemquestions.metricas;

import org.springframework.stereotype.Service;

@Service
public class MetricasDtoMapper {

    public static MetricasDto metricasToMetricasDto(Metricas metricas) {
        return  new MetricasDto(
                metricas.getId(),
                metricas.getSegundosTotaisDeProva(),
                metricas.getSegundosMediosPorQuestao(),
                metricas.getQuantidadeDeAcertos(),
                metricas.getNota()
        );
    }
    public static Metricas metricasDtoToMetricas(MetricasDto metricasDto) {
        return null;
    }
}
