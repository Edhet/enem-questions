package com.ablhds.Enemquestions.opcao;

import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Opcao {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String label;

    @NonNull
    private String texto;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Questao questao;
}
