package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class QuestaoService {
    private final QuestaoRepository questaoRepository;

    public Questao findById(Long id) {
        return questaoRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.QUESTAO_NAO_ENCONTRADA));
    }
}
