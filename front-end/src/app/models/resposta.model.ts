import { Opcao } from "./opcao.model"

export type Resposta = {
    id?: number
    idQuestao: number
    opcaoEscolhida: Opcao
}