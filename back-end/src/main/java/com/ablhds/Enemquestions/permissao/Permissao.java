package com.ablhds.Enemquestions.permissao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Data
@NoArgsConstructor
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

    @Override
    public String getAuthority() {
        return acao;
    }
}
