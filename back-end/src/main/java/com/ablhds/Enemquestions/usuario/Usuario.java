package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String nome;

    @NonNull
    @Column(unique = true)
    private String email;

    @NonNull
    private String senha;

    @NonNull
    private TipoAcesso tipoUsuario;

    @NonNull
    @OneToMany(fetch = FetchType.LAZY)
    private List<Permissao> permissoes;
}
