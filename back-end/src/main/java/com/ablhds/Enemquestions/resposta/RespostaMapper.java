package com.ablhds.Enemquestions.resposta;

public final class RespostaMapper {

    public static RespostaDto entityToDto(Resposta resposta) {
        return new RespostaDto(
                resposta.getId(),
                resposta.getQuestao().getId(),
                resposta.getOpcaoEscolhida().getId(),
                resposta.getAplicacaoProva().getId()
        );
    }

    public static Resposta dtoToEntity(RespostaDto respostaDto) {
        return null;
    }

}
