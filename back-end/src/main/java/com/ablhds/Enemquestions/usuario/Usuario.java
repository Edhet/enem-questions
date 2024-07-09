package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProva;
import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {
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
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permissao> permissoes;

    @OneToMany(fetch = FetchType.LAZY)
    private List<AplicacaoProva> aplicacoesProva;

    private Boolean contaAtiva;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissoes;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return contaAtiva;
    }
}
