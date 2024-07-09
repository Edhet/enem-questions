package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.opcao.Opcao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class RespostaService {
    private final RespostaRepository respostaRepository;

    public void responderQuestao(Opcao opcaoSelecionada, Resposta resposta) {
        if (opcaoSelecionada == null)
            return;

        var idOpcoes = resposta.getQuestao().getOpcoes().stream().map(Opcao::getId).toList();
        if (!idOpcoes.contains(opcaoSelecionada.getId()))
            throw new BadRequestException(ErrorMessages.RESPOSTA_OPCAO_INVALIDA);

        resposta.setOpcaoEscolhida(opcaoSelecionada);
        respostaRepository.save(resposta);
    }
}
