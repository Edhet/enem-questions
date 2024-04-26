package com.ablhds.Enemquestions.opcao;

public final class OpcaoMapper {

    public static OpcaoDto entityToDto(Opcao opcao) {
        return new OpcaoDto(
                opcao.getId(),
                opcao.getLabel(),
                opcao.getTexto()
        );
    }

    public static Opcao dtoToEntity(OpcaoDto opcaoDto) {
        return null;
    }
}
