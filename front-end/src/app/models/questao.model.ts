import { DificuldadeQuestao } from "./dificuldade-questao.model"
import { Opcao } from "./opcao.model"

export type Questao = {
    id?: number
    dificuldadeQuestao: DificuldadeQuestao
    numeroQuestao: number
    enunciado: string
    opcoes: Opcao[]
    labelOpcaoCorreta?: string
}