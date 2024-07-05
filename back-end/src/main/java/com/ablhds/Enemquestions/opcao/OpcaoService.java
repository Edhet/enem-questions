package com.ablhds.Enemquestions.opcao;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OpcaoService {
    private final OpcaoRepository opcaoRepository;

    public Opcao findById(Long id) {
        return opcaoRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.OPCAO_NAO_ENCONTRADA));
    }
}
