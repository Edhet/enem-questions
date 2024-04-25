package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.MetricasDto;
import com.ablhds.Enemquestions.metricas.MetricasDtoMapper;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.resposta.RespostaDto;
import com.ablhds.Enemquestions.resposta.RespostaDtoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public final class AplicacaoProvaDtoMapper{

    public static AplicacaoProvaDto aplicacaoProvaToAplicacaoProvaDto(AplicacaoProva aplicacaoProva){

        List<RespostaDto> respostaDtos = aplicacaoProva.getRespostas()
                .stream()
                .map(RespostaDtoMapper::respostaToRespostaDto)
                .collect(Collectors.toList());

        return new AplicacaoProvaDto(
                aplicacaoProva.getId(),
                aplicacaoProva.getEstadoAplicacaoProva().toString(),
                aplicacaoProva.getTempoInicioDeAplicacao().toString(),
                aplicacaoProva.getTempoFimDeAplicacao().toString(),
                respostaDtos,
                MetricasDtoMapper.metricasToMetricasDto(aplicacaoProva.getMetricas()),
                aplicacaoProva.getProva().getId()

        );
    }
    public static AplicacaoProva aplicacaoProvaDtoToAplicacaoProva(AplicacaoProvaDto aplicacaoProvaDto){
        return null;
    }


}
