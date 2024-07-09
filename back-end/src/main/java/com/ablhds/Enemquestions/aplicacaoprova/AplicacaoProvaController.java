package com.ablhds.Enemquestions.aplicacaoprova;

import com.ablhds.Enemquestions.resposta.RespostaDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/aplicacao-prova")
@AllArgsConstructor
public class AplicacaoProvaController {
    private final AplicacaoProvaService aplicacaoProvaService;

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.SEE')")
    @GetMapping("/{aplicacao-id}")
    public AplicacaoProvaDto getProva(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("aplicacao-id") Long aplicacaoId) {
        return AplicacaoProvaMapper.entityToDto(aplicacaoProvaService.findByIdGarantindoPropriedade(authHeader, aplicacaoId));
    }

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.EDIT')")
    @PostMapping("/novo")
    public void criarNovaAplicacao(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @RequestBody Long provaId) {
        aplicacaoProvaService.criarNovaAplicacaoProva(authHeader, provaId);
    }

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.EDIT')")
    @PostMapping("/{aplicacao-id}/responder")
    public void responderAplicacao(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("aplicacao-id") Long aplicacaoId, @Valid @RequestBody List<RespostaDto> respostas) {
        aplicacaoProvaService.responderAplicacaoProva(authHeader, aplicacaoId, respostas);
    }

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.EDIT')")
    @PatchMapping("/{aplicacao-id}/finalizar")
    public void finalizarAplicacao(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("aplicacao-id") Long aplicacaoId) {
        aplicacaoProvaService.finalizarAplicacaoProva(authHeader, aplicacaoId);
    }

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.EDIT')")
    @DeleteMapping("/{aplicacao-id}")
    public void excluirAplicacao(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("aplicacao-id") Long aplicacaoId) {
        aplicacaoProvaService.excluirAplicacaoProva(authHeader, aplicacaoId);
    }
}
