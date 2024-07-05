package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Metricas {
    @Id
    @GeneratedValue
    private Long id;

    private Long segundosTotaisDeProva;

    private Long segundosMediosPorQuestao;

    private Long quantidadeDeAcertos;

    private Float nota;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private AplicacaoProva aplicacaoProva;
}
