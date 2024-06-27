package com.ablhds.Enemquestions.aplicacaoprova;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/aplicacao-prova")
@AllArgsConstructor
public class AplicacaoProvaController {
    private final AplicacaoProvaService aplicacaoProvaService;

    @PreAuthorize("hasAuthority('APLICACAO_PROVA.EDIT')")
    @PostMapping("/novo/{prova-id}")
    public void criarNovaAplicacao(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader, @PathVariable("prova-id") String provaId) {
        aplicacaoProvaService.criarNovaAplicacao(authHeader, provaId);
    }
}
