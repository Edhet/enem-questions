package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.prova.Prova;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Questao {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private DificuldadeQuestao dificuldadeQuestao;

    @NonNull
    @Column(nullable = false)
    private Integer numeroQuestao;

    @ManyToOne(fetch = FetchType.LAZY)
    private Prova prova;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Opcao> opcoes;

    @OneToOne(fetch = FetchType.LAZY)
    private Opcao opcaoCorreta;
}
