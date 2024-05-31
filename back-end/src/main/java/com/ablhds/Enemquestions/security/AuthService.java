package com.ablhds.Enemquestions.security;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.exception.UnauthorizedException;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import com.ablhds.Enemquestions.usuario.Usuario;
import com.ablhds.Enemquestions.usuario.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private UsuarioService usuarioService;

    public LoginResponseDto autenticarSessao(LoginRequestDto loginRequestDto) {
        Usuario usuario;
        try {
            usuario = usuarioService.findByEmail(loginRequestDto.email());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.senha()));
        } catch (BadRequestException e) {
            throw new UnauthorizedException(ErrorMessages.USUARIO_EMAIL_INVALIDO);
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(ErrorMessages.USUARIO_SENHA_INVALIDA);
        }
        return new LoginResponseDto(jwtService.generateToken(usuario));
    }

    public LoginResponseDto cadastrarUsuario(CadastroRequestDto cadastroRequestDto) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(cadastroRequestDto, TipoAcesso.USUARIO_FINAL);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cadastroRequestDto.email(), cadastroRequestDto.senha()));
        return new LoginResponseDto(jwtService.generateToken(novoUsuario));
    }
}
