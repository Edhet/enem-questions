package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.Metricas;
import com.ablhds.Enemquestions.prova.Prova;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AplicacaoProva {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false)
    private EstadoAplicacaoProva estadoAplicacaoProva;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime tempoInicioDeAplicacao;

    private LocalDateTime tempoFimDeAplicacao;

    @OneToMany(mappedBy = "aplicacaoProva", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas;

    @NonNull
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Metricas metricas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario aplicante;

    @ManyToOne
    private Prova prova;
}
