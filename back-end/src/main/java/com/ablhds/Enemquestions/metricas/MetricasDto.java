package com.ablhds.Enemquestions.metricas;

public record MetricasDto(
        long id,
        long segundosTotaisDeProva,
        long segundosMediosPorQuestao,
        long quantidadeDeAcertos,
        float nota
) {
}
