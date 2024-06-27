package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.metricas.MetricasService;
import com.ablhds.Enemquestions.prova.Prova;
import com.ablhds.Enemquestions.prova.ProvaService;
import com.ablhds.Enemquestions.usuario.Usuario;
import com.ablhds.Enemquestions.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@AllArgsConstructor
public class AplicacaoProvaService {
    private final ProvaService provaService;

    private final UsuarioService usuarioService;

    private final MetricasService metricasService;

    private final AplicacaoProvaRepository aplicacaoProvaRepository;

    public void criarNovaAplicacao(String authHeader, String provaId) {
        Usuario usuario = usuarioService.findByAuthHeader(authHeader);

        long provaIdParseado;
        try {
            provaIdParseado = Long.parseLong(provaId);
        } catch (NumberFormatException e) {
            throw new BadRequestException(ErrorMessages.ID_INVALIDO);
        }
        Prova prova = provaService.findById(provaIdParseado);

        AplicacaoProva aplicacaoProva = new AplicacaoProva(
                null,
                EstadoAplicacaoProva.EM_ANDAMENTO,
                LocalDateTime.now(),
                null,
                null,
                metricasService.createNewMetricas(),
                usuario,
                prova,
                false
        );
        aplicacaoProva = aplicacaoProvaRepository.save(aplicacaoProva);
        usuarioService.adicionarAplicacaoProva(usuario, aplicacaoProva);
    }
}
