package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import org.springframework.stereotype.Service;

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

    public Long calcularTempoMedioQuestao(AplicacaoProva aplicacaoProva){
        return calcularSegundosTotais(aplicacaoProva)
                / aplicacaoProva
                .getProva()
                .getQuestoes()
                .size();
    }

    public Long CalcularNumeroAcertosnumeroAcertos (){
        // comparar e usar programacao funcional e incrementar um quando a resposta for igual a questao
    }



}
