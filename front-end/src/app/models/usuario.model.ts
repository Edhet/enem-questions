import { Permissao } from "./permissao.model"
import { TipoAcesso } from "./tipo-acesso.model"

export type Usuario = {
    id?: number
    nome: string
    email: string
    tipoUsuario: TipoAcesso
    permissoes: Permissao[]
}