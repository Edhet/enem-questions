package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.*;

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
}
