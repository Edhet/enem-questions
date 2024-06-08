package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.opcao.Opcao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProvaService {
    private final ProvaRepository provaRepository;

    public Prova addProva(Prova prova) {
        if (prova.getId() != null)
            throw new BadRequestException(ErrorMessages.PROVA_COM_ID_ARBITRARIO);

        if (prova.possuiQuestoesRepetidas())
            throw new BadRequestException(ErrorMessages.PROVA_TEM_QUESTOES_REPETIDAS);

        prova.setProvaExcluida(false);
        prova.getQuestoes().forEach(questao -> {
            questao.setProva(prova);
            questao.getOpcoes().forEach(opcao -> opcao.setQuestao(questao));
            var labels = questao.getOpcoes().stream().map(Opcao::getLabel).toList();

            if (questao.getLabelOpcaoCorreta() == null)
                throw new BadRequestException(ErrorMessages.PROVA_QUESTAO_SEM_OPCAO_CORRETA);
            if (!labels.contains(questao.getLabelOpcaoCorreta()))
                throw new BadRequestException(ErrorMessages.QUESTAO_CORRETA_FORA_DA_LISTA_DE_OPCOES);
            if (questao.possuiOpcoesRepetidas())
                throw new BadRequestException(ErrorMessages.QUESTAO_PROVA_TEM_LABELS_REPETIDOS);
        });

        return provaRepository.save(prova);
    }

    public Prova updateProva(Prova prova) {
        var provaAntiga = findById(prova.getId());

        provaAntiga.setNome(prova.getNome());
        provaAntiga.setAreaProva(prova.getAreaProva());
        provaAntiga.setDiaDeProva(prova.getDiaDeProva());
        provaAntiga.setAno(prova.getAno());
        provaAntiga.setCor(prova.getCor());
        provaAntiga.setQuestoes(prova.getQuestoes());

        return provaRepository.save(provaAntiga);
    }

    public void excluirProva(Long id) {
        var prova = findById(id);
        prova.setProvaExcluida(true);
        provaRepository.save(prova);
    }

    public Prova findById(Long id) {
        return provaRepository.findAllByIdAndProvaExcluidaFalse(id).orElseThrow(() -> new BadRequestException(ErrorMessages.PROVA_NAO_ENCONTRADA));
    }

    public List<Prova> findAll() {
        return provaRepository.findAllByProvaExcluidaFalse();
    }
}
