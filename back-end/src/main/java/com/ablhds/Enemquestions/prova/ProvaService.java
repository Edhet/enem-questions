package com.ablhds.Enemquestions.prova;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

            if (!questao.opcaoCorretaValida())
                throw new BadRequestException(ErrorMessages.QUESTAO_CORRETA_FORA_DA_LISTA_DE_OPCOES);
            if (questao.possuiOpcoesRepetidas())
                throw new BadRequestException(ErrorMessages.QUESTAO_PROVA_TEM_LABELS_REPETIDOS);
        });

        return provaRepository.save(prova);
    }

    @CachePut(value = "prova", key = "#prova.id")
    public Prova updateProva(Prova prova) {
        var provaAntiga = findById(prova.getId());

        if (prova.possuiQuestoesRepetidas())
            throw new BadRequestException(ErrorMessages.PROVA_TEM_QUESTOES_REPETIDAS);
        prova.getQuestoes().forEach(questao -> {
            if (!questao.opcaoCorretaValida())
                throw new BadRequestException(ErrorMessages.QUESTAO_CORRETA_FORA_DA_LISTA_DE_OPCOES);
            if (questao.possuiOpcoesRepetidas())
                throw new BadRequestException(ErrorMessages.QUESTAO_PROVA_TEM_LABELS_REPETIDOS);
        });

        provaAntiga.setNome(prova.getNome());
        provaAntiga.setAreaProva(prova.getAreaProva());
        provaAntiga.setDiaDeProva(prova.getDiaDeProva());
        provaAntiga.setAno(prova.getAno());
        provaAntiga.setCor(prova.getCor());
        provaAntiga.setQuestoes(prova.getQuestoes());

        return provaRepository.save(provaAntiga);
    }

    @CacheEvict(value = "prova", key = "#id")
    public void excluirProva(Long id) {
        var prova = findById(id);
        prova.setProvaExcluida(true);
        provaRepository.save(prova);
    }

    @Cacheable(value = "prova", key = "#id")
    public Prova findById(Long id) {
        return provaRepository.findAllByIdAndProvaExcluidaFalse(id).orElseThrow(() -> new BadRequestException(ErrorMessages.PROVA_NAO_ENCONTRADA));
    }

    @Cacheable(value = "prova")
    public List<Prova> findAll() {
        return provaRepository.findAllByProvaExcluidaFalse();
    }
}
