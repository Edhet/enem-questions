package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.prova.Prova;
import com.ablhds.Enemquestions.questao.Questao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetricasService // falta colocar a aplicacao prova
{
    public void InserirMetricasDaAplicacao(AplicacaoProva aplicacaoProva, Metricas metricas) {
        metricas.setSegundosTotaisDeProva(calcularSegundosTotais(aplicacaoProva));
        metricas.setSegundosMediosPorQuestao(calcularTempoMedioQuestao(aplicacaoProva));

        // como resolver isso
    }

    public Long calcularSegundosTotais(AplicacaoProva aplicacaoProva) {
        int SegundoTotais = Integer.parseInt(aplicacaoProva.getTempoFimDeAplicacao() - aplicacaoProva.getTempoInicioDeAplicacao());
    }

    public Long calcularTempoMedioQuestao(AplicacaoProva aplicacaoProva) {
        return calcularSegundosTotais(aplicacaoProva) / aplicacaoProva
                .getProva()
                .getQuestoes()
                .size();
    }

    public Long CalcularNumeroAcertos(AplicacaoProva aplicacaoProva) {

        return aplicacaoProva.getRespostas()
                .stream()
                .map(a -> a.getOpcaoEscolhida().getId())
                .filter(aLong -> aLong.equals(
                                aplicacaoProva.getProva().getQuestoes()
                                        .stream()
                                        .map(Questao::getOpcaoCorreta)
                                        .map(Opcao::getId)
                        )
                ).count();
    }


}
