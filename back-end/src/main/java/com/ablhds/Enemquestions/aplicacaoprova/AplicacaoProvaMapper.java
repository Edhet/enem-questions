package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.MetricasMapper;
import com.ablhds.Enemquestions.resposta.RespostaDto;
import com.ablhds.Enemquestions.resposta.RespostaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AplicacaoProvaMapper {

    public static AplicacaoProvaDto entityToDto(AplicacaoProva aplicacaoProva) {

        List<RespostaDto> respostaDtos = aplicacaoProva.getRespostas()
                .stream()
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
        return null;
    }


}
