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
        Metricas metricas = new Metricas();

        metricas.setId(metricasDto.id());
        metricas.setSegundosTotaisDeProva(metricasDto.segundosTotaisDeProva());
        metricas.setSegundosMediosPorQuestao(metricasDto.segundosMediosPorQuestao());
        metricas.setQuantidadeDeAcertos(metricasDto.quantidadeDeAcertos());
        metricas.setNota(metricasDto.nota());
        return metricas;
    }
}
