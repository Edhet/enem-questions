import { EstadoAplicacaoProva } from "./estado-aplicacao-prova.model"
import { Metricas } from "./metricas.model"
import { Resposta } from "./resposta.model"

export type AplicacaoProva = {
    id?: number
    estadoAplicacaoProva: EstadoAplicacaoProva
    tempoInicioDeAplicacao: Date
    tempoFimDeAplicacao: Date
    respostas: Resposta[]
    metricas: Metricas
    idProva: number
}