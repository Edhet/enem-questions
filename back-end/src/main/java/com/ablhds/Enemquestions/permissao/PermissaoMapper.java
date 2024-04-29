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

        Permissao permissao = new Permissao();

        permissao.setTipoPermissao(tipoPermissao);
        permissao.setId(permissaoDto.id());
        permissao.setTipoPermissao(tipoPermissao);

        return permissao;
    }
}
