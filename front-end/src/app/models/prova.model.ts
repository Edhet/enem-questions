import { AreaProva } from "./area-prova.model"
import { DiaDeProva } from "./dia-de-prova.model"
import { Questao } from "./questao.model"

export type Prova = {
    id?: number
    nome: string
    areaProva: AreaProva
    diaDeProva: DiaDeProva
    ano: number
    cor: string
    excluida?: boolean
    questoes: Questao[]
}