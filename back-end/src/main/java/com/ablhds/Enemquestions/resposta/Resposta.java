package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Questao questao;

    @ManyToOne(fetch = FetchType.EAGER)
    private Opcao opcaoEscolhida;

    @ManyToOne(fetch = FetchType.LAZY)
    private AplicacaoProva aplicacaoProva;

    public boolean reaspostaCorreta() {
        if (!this.getQuestao().getId().equals(this.id))
            throw new BadRequestException(ErrorMessages.RESPOSTA_QUESTAO_INVALIDA);
        return this.getOpcaoEscolhida().getLabel().equals(this.getQuestao().getLabelOpcaoCorreta());
    }
}
