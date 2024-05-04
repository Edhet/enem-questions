package com.ablhds.Enemquestions.metricas;

public final class MetricasMapper {
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
        return new Metricas(
                metricasDto.id(),
                metricasDto.segundosTotaisDeProva(),
                metricasDto.segundosMediosPorQuestao(),
                metricasDto.quantidadeDeAcertos(),
                metricasDto.nota(),
                null
        );
    }
}
