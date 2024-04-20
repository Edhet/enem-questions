package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Resposta {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @ManyToOne
    private Questao questao;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Opcao opcaoEscolhida;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private AplicacaoProva aplicacaoProva;
}
