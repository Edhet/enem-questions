package com.ablhds.Enemquestions.metricas;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Metricas {
    @Id
    @GeneratedValue
    private Long id;

    private Long segundosTotaisDeProva;

    private Long segundosMediosPorQuestao;

    private Long quantidadeDeAcertos;

    private Float nota;

    @NonNull
    @OneToOne(fetch = FetchType.LAZY)
    private AplicacaoProva aplicacaoProva;
}
