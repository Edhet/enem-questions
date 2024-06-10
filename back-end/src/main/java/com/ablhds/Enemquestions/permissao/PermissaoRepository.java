package com.ablhds.Enemquestions.permissao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

    List<Permissao> findAllByTipoPermissao(TipoAcesso tipoPermissao);
}
