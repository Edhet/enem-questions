package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.permissao.PermissaoDto;

import java.util.List;

public record UsuarioDto(
        Long id,
        String nome,
        String email,
        String tipoUsuario,
        List<PermissaoDto> permissoes,
        List<AplicacaoProvaDto> aplicacoesProva
) {
}
