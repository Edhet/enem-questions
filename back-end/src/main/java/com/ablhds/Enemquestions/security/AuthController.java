package com.ablhds.Enemquestions.security;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     * Este endpoint vazio vai rodar o middleware que verifica se o JWT é válido, se o cliente receber status 200, ele é
     * válido, do contrário, não.
     */
    @GetMapping
    public void runAuthFilter() {
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        return authService.autenticarSessao(loginRequestDto);
    }

    @PostMapping("/cadastro")
    public LoginResponseDto cadastrar(@RequestBody CadastroRequestDto cadastroRequestDto) {
        return authService.cadastrarUsuario(cadastroRequestDto);
    }
}
