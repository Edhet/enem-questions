package com.ablhds.Enemquestions.questao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class QuestaoService {
    private final QuestaoRepository questaoRepository;
}
