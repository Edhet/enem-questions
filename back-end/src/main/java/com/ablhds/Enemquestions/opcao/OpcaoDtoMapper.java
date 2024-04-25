package com.ablhds.Enemquestions.opcao;

import org.springframework.stereotype.Service;

@Service
public class OpcaoDtoMapper {

    public static OpcaoDto opcaoToOpcaoDto(Opcao opcao) {
        return new OpcaoDto(
                opcao.getId(),
                opcao.getLabel(),
                opcao.getTexto()
        );
    }
    public static Opcao opcaoDtoToOpcao(OpcaoDto opcaoDto) {
        return null;
    }
}
