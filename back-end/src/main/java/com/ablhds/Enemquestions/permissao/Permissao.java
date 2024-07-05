package com.ablhds.Enemquestions.permissao;

import com.ablhds.Enemquestions.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Permissao implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String acao;

    @NonNull
    @Column(nullable = false)
    private TipoAcesso tipoPermissao;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @Override
    public String getAuthority() {
        return acao;
    }
}
