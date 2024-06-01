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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UsuarioService usuarioService;

    private final PasswordEncoder passwordEncoder;

    public LoginResponseDto autenticarSessao(LoginRequestDto loginRequestDto) {
        Usuario usuario;
        try {
            usuario = usuarioService.findByEmail(loginRequestDto.email());
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.email(), loginRequestDto.senha()));
        } catch (BadRequestException e) {
            throw new UnauthorizedException(ErrorMessages.USUARIO_EMAIL_NAO_ENCONTRADO);
        } catch (AuthenticationException e) {
            throw new UnauthorizedException(ErrorMessages.USUARIO_SENHA_INVALIDA);
        }
        return new LoginResponseDto(jwtService.generateToken(usuario));
    }

    public LoginResponseDto cadastrarUsuario(CadastroRequestDto cadastroRequestDto) {
        String senhaCriptografada = cadastroRequestDto.senha() == null || cadastroRequestDto.senha().isEmpty()
                ? null
                : passwordEncoder.encode(cadastroRequestDto.senha());

        CadastroRequestDto cadastroCriptografado = new CadastroRequestDto(
                cadastroRequestDto.nome(),
                cadastroRequestDto.email(),
                senhaCriptografada
        );
        Usuario novoUsuario = usuarioService.cadastrarUsuario(cadastroCriptografado, TipoAcesso.USUARIO_FINAL);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cadastroRequestDto.email(), cadastroRequestDto.senha()));
        return new LoginResponseDto(jwtService.generateToken(novoUsuario));
    }
}
