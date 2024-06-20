package com.ablhds.Enemquestions.opcao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OpcaoService {
    private final OpcaoRepository opcaoRepository;

}
