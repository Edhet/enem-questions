package com.ablhds.Enemquestions.resposta;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.opcao.Opcao;
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
    @ManyToOne(fetch = FetchType.EAGER)
    private Opcao opcaoEscolhida;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private AplicacaoProva aplicacaoProva;
}
