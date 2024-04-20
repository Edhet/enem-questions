package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.metricas.Metricas;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class AplicacaoProva {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private EstadoAplicacaoProva estadoAplicacaoProva;

    @NonNull
    private Date tempoInicioDeAplicacao;

    private Date tempoFimDeAplicacao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Resposta> respostas;

    @NonNull
    @OneToOne(fetch = FetchType.EAGER)
    private Metricas metricas;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario aplicante;
}
