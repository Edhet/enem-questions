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
        Opcao opcao = new Opcao();
        opcao.setId(opcaoDto.id());
        opcao.setLabel(opcaoDto.label());
        opcao.setTexto(opcaoDto.texto());

        return opcao;
    }
}
