package com.ablhds.Enemquestions.opcao;

import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Opcao {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String label;

    @NonNull
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private Questao questao;
}
