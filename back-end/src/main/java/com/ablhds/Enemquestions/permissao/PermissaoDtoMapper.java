package com.ablhds.Enemquestions.permissao;

import org.springframework.stereotype.Service;

@Service
public final class PermissaoDtoMapper{


    public static PermissaoDto permissaoToDto(Permissao permissao) {
        return new PermissaoDto(
                permissao.getId(),
                permissao.getAcao(),
                permissao.getTipoPermissao().toString()
        );
    }
    public static Permissao DtoToPermissao(PermissaoDto dto) {
        return null;
    }
}
