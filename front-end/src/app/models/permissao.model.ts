import { TipoAcesso } from "./tipo-acesso.model"

export type Permissao = {
    id?: number
    acao: string
    tipoPermissao: TipoAcesso
}