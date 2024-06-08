package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.prova.Prova;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
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
    @Column(nullable = false)
    private String enunciado;

    @NonNull
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Opcao> opcoes;

    @NonNull
    @Column(nullable = false)
    private String labelOpcaoCorreta;

    public boolean possuiOpcoesRepetidas() {
        var todosOsLabels = this.opcoes.stream().map(Opcao::getLabel).toList();
        var labels = new ArrayList<>();
        for (var label : todosOsLabels) {
            if (labels.contains(label))
                return true;
            labels.add(label);
        }
        return false;
    }
}
