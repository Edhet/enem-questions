package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.Year;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Prova {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private AreaProva areaProva;

    @NonNull
    private DiaDeProva diaDeProva;

    @NonNull
    private Year ano;

    @NonNull
    private String cor;

    @NonNull
    private Boolean provaExcluida;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Questao> questoes;
}
