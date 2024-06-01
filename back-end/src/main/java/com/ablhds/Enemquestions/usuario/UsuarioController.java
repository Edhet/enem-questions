package com.ablhds.Enemquestions.usuario;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @GetMapping("/info")
    public UsuarioDto informacoesDoUsuario(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return usuarioService.getInformacoesDoUsuario(authHeader);
    }

    @PatchMapping("/desativar")
    public void desativar(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        usuarioService.desativarConta(authHeader);
    }

    @PatchMapping("/ativar")
    public void ativar(@RequestBody String email) {
        usuarioService.ativarConta(email);
    }
}
