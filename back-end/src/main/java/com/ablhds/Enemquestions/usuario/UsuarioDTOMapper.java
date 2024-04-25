package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDtoMapper;
import com.ablhds.Enemquestions.permissao.PermissaoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import com.ablhds.Enemquestions.permissao.PermissaoDtoMapper;

@Service
public  final class UsuarioDTOMapper{

    public static UsuarioDto usuarioToDto(Usuario usuario) {
        List<AplicacaoProvaDto> aplicacaoProvaDtos = usuario.getAplicacoesProva()
                .stream()
                .map(AplicacaoProvaDtoMapper::aplicacaoProvaToAplicacaoProvaDto)
                .collect(Collectors.toList());

        List<PermissaoDto> permissaoDtos = usuario.getPermissoes()
                .stream()
                .map(PermissaoDtoMapper::permissaoToDto)
                .collect(Collectors.toList());

        return new UsuarioDto(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTipoUsuario().toString(),
                permissaoDtos,
                aplicacaoProvaDtos);
    }

    public static Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return null;
    }
}
