package com.ablhds.Enemquestions.metricas;

import org.springframework.stereotype.Service;

@Service
public class MetricasMapper {

    public static MetricasDto entityToDto(Metricas metricas) {
        return new MetricasDto(
                metricas.getId(),
                metricas.getSegundosTotaisDeProva(),
                metricas.getSegundosMediosPorQuestao(),
                metricas.getQuantidadeDeAcertos(),
                metricas.getNota()
        );
    }

    public static Metricas dtoToEntity(MetricasDto metricasDto) {
        return null;
    }
}
