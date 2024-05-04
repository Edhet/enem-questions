package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.Metricas;
import com.ablhds.Enemquestions.prova.Prova;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
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

    @OneToMany(fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private Metricas metricas;

    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario aplicante;

    @ManyToOne
    private Prova prova;
}
