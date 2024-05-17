package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaMapper;
import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.PermissaoDto;
import com.ablhds.Enemquestions.permissao.PermissaoMapper;
import com.ablhds.Enemquestions.permissao.TipoAcesso;

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
        TipoAcesso tipoAcesso = TipoAcesso.valueOf(usuarioDto.tipoUsuario());

        List<Permissao> permissoes = usuarioDto.permissoes()
                .stream()
                .map(PermissaoMapper::dtoToEntity)
                .collect(Collectors.toList());

        List<AplicacaoProva> aplicacoesProva = usuarioDto.aplicacoesProva()
                .stream()
                .map(AplicacaoProvaMapper::dtoToEntity).collect(Collectors.toList());

        return new Usuario(
                usuarioDto.id(),
                usuarioDto.nome(),
                usuarioDto.email(),
                null,
                tipoAcesso,
                permissoes,
                aplicacoesProva
        );
    }
}
