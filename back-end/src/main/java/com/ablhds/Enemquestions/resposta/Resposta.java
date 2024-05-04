package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Column(nullable = false)
    private Questao questao;

    @ManyToOne(fetch = FetchType.EAGER)
    @Column(nullable = false)
    private Opcao opcaoEscolhida;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private AplicacaoProva aplicacaoProva;
}
