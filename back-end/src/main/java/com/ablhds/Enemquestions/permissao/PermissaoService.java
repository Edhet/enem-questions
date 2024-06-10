package com.ablhds.Enemquestions.permissao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PermissaoService {
    private final PermissaoRepository permissaoRepository;

    public List<Permissao> findPermissoesPorTipoAcesso(TipoAcesso tipoAcesso) {
        return permissaoRepository.findAllByTipoPermissao(tipoAcesso);
    }
}
