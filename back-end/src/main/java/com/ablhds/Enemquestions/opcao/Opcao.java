package com.ablhds.Enemquestions.opcao;

import com.ablhds.Enemquestions.questao.Questao;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Opcao implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String label;

    @NonNull
    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    private Questao questao;
}
