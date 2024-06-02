package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.security.AuthService;
import com.ablhds.Enemquestions.security.LoginRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/usuario")
@AllArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    private final AuthService authService;

    @GetMapping("/info")
    public UsuarioDto informacoesDoUsuario(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return usuarioService.getInformacoesDoUsuario(authHeader);
    }

    @PatchMapping("/desativar")
    public void desativar(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        usuarioService.desativarConta(authHeader);
    }

    @PatchMapping("/ativar")
    public void ativar(@Valid @RequestBody LoginRequestDto loginInfo) {
        authService.ativarConta(loginInfo);
    }
}
