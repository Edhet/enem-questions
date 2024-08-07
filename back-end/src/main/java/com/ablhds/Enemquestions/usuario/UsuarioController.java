package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaDto;
import com.ablhds.Enemquestions.aplicacaoprova.AplicacaoProvaMapper;
import com.ablhds.Enemquestions.permissao.PermissaoDto;
import com.ablhds.Enemquestions.permissao.PermissaoMapper;
import com.ablhds.Enemquestions.security.AuthService;
import com.ablhds.Enemquestions.security.LoginRequestDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/aplicacoes")
    public List<AplicacaoProvaDto> provasDoUsuario(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        return usuarioService.getAplicacoesProva(authHeader).stream()
                .map(AplicacaoProvaMapper::entityToDto)
                .toList();
    }

    @PreAuthorize("hasAuthority('PERMISSAO.EDIT_ALL')")
    @PatchMapping("/{email}")
    public void darPermissao(@PathVariable String email, @Valid @RequestBody PermissaoDto permissaoDto) {
        usuarioService.darPermissao(email, PermissaoMapper.dtoToEntity(permissaoDto));
    }
}
