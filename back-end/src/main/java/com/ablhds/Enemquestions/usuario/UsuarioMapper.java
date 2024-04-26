package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaMapper;
import com.ablhds.Enemquestions.permissao.PermissaoDto;
import com.ablhds.Enemquestions.permissao.PermissaoMapper;

import java.util.List;
import java.util.stream.Collectors;

public final class UsuarioMapper {

    public static UsuarioDto entityToDto(Usuario usuario) {
        List<AplicacaoProvaDto> aplicacaoProvaDtos = usuario.getAplicacoesProva()
                .stream()
                .map(AplicacaoProvaMapper::entityToDto)
                .collect(Collectors.toList());

        List<PermissaoDto> permissaoDtos = usuario.getPermissoes()
                .stream()
                .map(PermissaoMapper::entityToDto)
                .collect(Collectors.toList());

        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().toString(),
                permissaoDtos,
                aplicacaoProvaDtos);
    }

    public static Usuario dtoToEntity(UsuarioDto usuarioDto) {
        return null;
    }
}
