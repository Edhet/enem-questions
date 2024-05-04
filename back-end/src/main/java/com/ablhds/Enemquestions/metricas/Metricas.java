package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
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

    @OneToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private AplicacaoProva aplicacaoProva;
}
