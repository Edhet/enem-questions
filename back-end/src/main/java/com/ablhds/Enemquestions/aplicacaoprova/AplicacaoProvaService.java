package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.exception.UnauthorizedException;
import com.ablhds.Enemquestions.metricas.Metricas;
import com.ablhds.Enemquestions.opcao.Opcao;
import com.ablhds.Enemquestions.opcao.OpcaoDto;
import com.ablhds.Enemquestions.opcao.OpcaoService;
import com.ablhds.Enemquestions.prova.Prova;
import com.ablhds.Enemquestions.prova.ProvaService;
import com.ablhds.Enemquestions.questao.Questao;
import com.ablhds.Enemquestions.resposta.Resposta;
import com.ablhds.Enemquestions.resposta.RespostaDto;
import com.ablhds.Enemquestions.resposta.RespostaService;
import com.ablhds.Enemquestions.usuario.Usuario;
import com.ablhds.Enemquestions.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AplicacaoProvaService {
    private final ProvaService provaService;

    private final UsuarioService usuarioService;

    private final RespostaService respostaService;

    private final OpcaoService opcaoService;

    private final AplicacaoProvaRepository aplicacaoProvaRepository;

    public void criarNovaAplicacaoProva(String authHeader, Long provaId) {
        Usuario usuario = usuarioService.findByAuthHeader(authHeader);
        Prova prova = provaService.findById(provaId);

        AplicacaoProva aplicacaoProva = new AplicacaoProva(
                null,
                EstadoAplicacaoProva.EM_ANDAMENTO,
                LocalDateTime.now(),
                null,
                null,
                new Metricas(),
                usuario,
                prova
        );

        List<Resposta> respostas = new ArrayList<>();
        for (Questao questao : prova.getQuestoes()) {
            respostas.add(new Resposta(
                    null,
                    questao,
                    null,
                    aplicacaoProva
            ));
        }

        aplicacaoProva.setRespostas(respostas);
        aplicacaoProva = aplicacaoProvaRepository.save(aplicacaoProva);
        usuarioService.adicionarAplicacaoProva(usuario, aplicacaoProva);
    }

    public void responderAplicacaoProva(String authHeader, Long aplicacaoId, List<RespostaDto> respostaDtos) {
        AplicacaoProva aplicacao = findByIdGarantindoPropriedade(authHeader, aplicacaoId);

        List<Long> idsRespostaDtos = respostaDtos.stream().map(RespostaDto::idQuestao).toList();
        List<Long> idQuestoes = aplicacao.getProva().getQuestoes().stream().map(Questao::getId).toList();

        for (Long idRespondida : idsRespostaDtos) {
            if (!idQuestoes.contains(idRespondida))
                throw new BadRequestException(ErrorMessages.RESPOSTA_QUESTAO_INVALIDA);
        }

        for (Resposta resposta : aplicacao.getRespostas()) {
            OpcaoDto opcaoSelecionadaDto = respostaDtos.stream()
                    .filter(r -> r.id().equals(resposta.getId()))
                    .map(RespostaDto::opcaoEscolhida)
                    .toList()
                    .getFirst();

            Opcao opcaoSelecionada = opcaoService.findById(opcaoSelecionadaDto.id());
            respostaService.responderQuestao(opcaoSelecionada, resposta);
        }
    }

    public void finalizarAplicacaoProva(String authHeader, Long aplicacaoId) {
        AplicacaoProva aplicacao = findByIdGarantindoPropriedade(authHeader, aplicacaoId);
        aplicacao.setEstadoAplicacaoProva(EstadoAplicacaoProva.FINALIZADA);
        aplicacao.setTempoFimDeAplicacao(LocalDateTime.now());
        // TODO: CALCULAR METRICAS

        aplicacaoProvaRepository.save(aplicacao);
    }

    public void excluirAplicacaoProva(String authHeader, Long aplicacaoId) {
        AplicacaoProva aplicacao = findByIdGarantindoPropriedade(authHeader, aplicacaoId);
        aplicacaoProvaRepository.delete(aplicacao);
    }

    public AplicacaoProva findByIdGarantindoPropriedade(String authHeader, Long aplicacaoId) {
        AplicacaoProva aplicacao = findById(aplicacaoId);
        garantirQueAplicacaoPertenceAoUsuario(authHeader, aplicacao);
        return aplicacao;
    }

    public AplicacaoProva findById(Long id) {
        return aplicacaoProvaRepository.findById(id).orElseThrow(() -> new BadRequestException(ErrorMessages.APLICACAO_PROVA_NAO_ENCONTRADA));
    }

    private void garantirQueAplicacaoPertenceAoUsuario(String authHeader, AplicacaoProva aplicacao) {
        Usuario aplicante = aplicacao.getAplicante();
        Usuario usuario = usuarioService.findByAuthHeader(authHeader);

        if (!aplicante.getId().equals(usuario.getId()))
            throw new UnauthorizedException(ErrorMessages.APLICACAO_PROVA_NAO_ENCONTRADA);

    }
}
