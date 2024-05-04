package com.ablhds.Enemquestions.permissao;

public final class PermissaoMapper {
    public static PermissaoDto entityToDto(Permissao permissao) {
        return new PermissaoDto(
                permissao.getId(),
                permissao.getAcao(),
                permissao.getTipoPermissao().toString()
        );
    }

    public static Permissao dtoToEntity(PermissaoDto permissaoDto) {
        TipoAcesso tipoPermissao = TipoAcesso.valueOf(permissaoDto.tipoPermissao());
        return new Permissao(
                permissaoDto.id(),
                permissaoDto.acao(),
                tipoPermissao
        );
    }
}
