package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaMapper;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.opcao.OpcaoMapper;
import com.ablhds.Enemquestions.questao.Questao;
import com.ablhds.Enemquestions.questao.QuestaoDto;
import com.ablhds.Enemquestions.questao.QuestaoMapper;

public final class RespostaMapper {

    public static RespostaDto entityToDto(Resposta resposta) {
        QuestaoDto questaoDto = QuestaoMapper.entityToDto(resposta.getQuestao());
        OpcaoDto opcaoDto = OpcaoMapper.entityToDto(resposta.getOpcaoEscolhida());
        AplicacaoProvaDto aplicacaoProvaDto= AplicacaoProvaMapper.entityToDto(resposta.getAplicacaoProva());
        return new RespostaDto(
                resposta.getId(),
                questaoDto,
                opcaoDto,
                aplicacaoProvaDto
        );
    }

    public static Resposta dtoToEntity(RespostaDto respostaDto) {

        Questao questao = (QuestaoMapper.dtoToEntity(respostaDto.questao()));

        Opcao opcao = OpcaoMapper.dtoToEntity(respostaDto.opcaoEscolhida());

        AplicacaoProva aplicacaoProva = AplicacaoProvaMapper.dtoToEntity(respostaDto.aplicacaoProvaDto());

        Resposta resposta = new Resposta();
        resposta.setId(respostaDto.id());
        resposta.setQuestao(questao);
        resposta.setOpcaoEscolhida(opcao);
        resposta.setAplicacaoProva(aplicacaoProva);

        return resposta ;
    }

}
