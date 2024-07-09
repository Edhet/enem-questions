package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.Questao;
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
public class Prova implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(nullable = false)
    private AreaProva areaProva;

    @NonNull
    @Column(nullable = false)
    private DiaDeProva diaDeProva;

    @NonNull
    @Column(nullable = false)
    private Long ano;

    @NonNull
    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private Boolean provaExcluida;

    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Questao> questoes;

    public boolean possuiQuestoesRepetidas() {
        var todosOsNumeroQuestao = this.questoes.stream().map(Questao::getNumeroQuestao).toList();
        var numeros = new ArrayList<>();
        for (var numQuestao : todosOsNumeroQuestao) {
            if (numeros.contains(numQuestao))
                return true;
            numeros.add(numQuestao);
        }
        return false;
    }
}
