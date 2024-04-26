package com.ablhds.Enemquestions.permissao;

public final class PermissaoMapper {


    public static PermissaoDto entityToDto(Permissao permissao) {
        return new PermissaoDto(
                permissao.getId(),
                permissao.getAcao(),
                permissao.getTipoPermissao().toString()
        );
    }

    public static Permissao dtoToEntity(PermissaoDto dto) {
        return null;
    }
}
