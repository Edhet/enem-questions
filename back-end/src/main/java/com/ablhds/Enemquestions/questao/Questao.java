package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.prova.Prova;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Questao {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private DificuldadeQuestao dificuldadeQuestao;

    @NonNull
    private Integer numeroQuestao;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Prova prova;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Opcao> opcoes;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    private Opcao opcaoCorreta;
}
