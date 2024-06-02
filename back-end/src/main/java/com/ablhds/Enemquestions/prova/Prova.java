package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.Questao;
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
public class Prova {
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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Questao> questoes;
}
