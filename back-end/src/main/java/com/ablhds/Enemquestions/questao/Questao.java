package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.prova.Prova;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Questao implements Serializable {
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
    @OneToMany(mappedBy = "questao", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Opcao> opcoes;

    @NonNull
    @Column(nullable = false)
    private String labelOpcaoCorreta;

    public boolean opcaoCorretaValida() {
        var labels = this.getOpcoes().stream().map(Opcao::getLabel).toList();
        return labels.contains(this.getLabelOpcaoCorreta());
    }

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
