package com.ablhds.Enemquestions.questao;

import com.ablhds.Enemquestions.opcao.Opcao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class QuestaoService {
    private final QuestaoRepository questaoRepository;

    public boolean questaoPossuiOpcoesComLabelsRepetidos(Questao questao) {
        List<String> todosOsLabels = questao.getOpcoes().stream().map(Opcao::getLabel).toList();
        List<String> labels = new ArrayList<>();
        for (var label : todosOsLabels) {
            if (todosOsLabels.contains(label))
                return true;
            labels.add(label);
        }
        return false;
    }
}
