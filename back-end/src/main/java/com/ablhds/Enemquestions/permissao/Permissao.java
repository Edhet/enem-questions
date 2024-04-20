package com.ablhds.Enemquestions.permissao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Permissao {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String acao;

    @NonNull
    private TipoAcesso tipoPermissao;
}
