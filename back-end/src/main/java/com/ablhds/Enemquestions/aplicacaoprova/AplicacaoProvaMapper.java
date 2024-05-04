package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.Metricas;
import com.ablhds.Enemquestions.metricas.MetricasMapper;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.resposta.RespostaDto;
import com.ablhds.Enemquestions.resposta.RespostaMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public final class AplicacaoProvaMapper {
    public static AplicacaoProvaDto entityToDto(AplicacaoProva aplicacaoProva) {
        List<RespostaDto> respostaDtos = aplicacaoProva.getRespostas().stream()
                .map(RespostaMapper::entityToDto)
                .collect(Collectors.toList());

        return new AplicacaoProvaDto(
                aplicacaoProva.getId(),
                aplicacaoProva.getEstadoAplicacaoProva().toString(),
                aplicacaoProva.getTempoInicioDeAplicacao().toString(),
                aplicacaoProva.getTempoFimDeAplicacao().toString(),
                respostaDtos,
                MetricasMapper.entityToDto(aplicacaoProva.getMetricas()),
                aplicacaoProva.getProva().getId()

        );
    }

    public static AplicacaoProva dtoToEntity(AplicacaoProvaDto aplicacaoProvaDto) {
        EstadoAplicacaoProva estadoAplicacaoProva = EstadoAplicacaoProva.valueOf(aplicacaoProvaDto.estadoAplicacaoProva());

        List<Resposta> respostas = aplicacaoProvaDto.respostas()
                .stream()
                .map(RespostaMapper::dtoToEntity)
                .collect(Collectors.toList());

        Metricas metricas = MetricasMapper.dtoToEntity(aplicacaoProvaDto.metricas());

        LocalDateTime tempoInicio = LocalDateTime.parse(aplicacaoProvaDto.tempoInicioDeAplicacao());
        LocalDateTime tempoFinal = LocalDateTime.parse(aplicacaoProvaDto.tempoFimDeAplicacao());

        return new AplicacaoProva(
                aplicacaoProvaDto.id(),
                estadoAplicacaoProva,
                tempoInicio,
                tempoFinal,
                respostas,
                metricas,
                null,
                null
        );
    }
}
