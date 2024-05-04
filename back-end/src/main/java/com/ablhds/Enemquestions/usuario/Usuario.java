package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String nome;

    @NonNull
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @NonNull
    @Column(nullable = false)
    private TipoAcesso tipoUsuario;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissoes;

    @OneToMany
    @Column(nullable = false)
    private List<AplicacaoProva> aplicacoesProva;
}
