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

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;
    private final JwtService jwtService;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
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

    public LoginResponseDto cadastrarUsuarioFinal(CadastroRequestDto cadastroRequestDto) {
        // TODO: Dar permissões padrão de usuário final
        Usuario novoUsuario;
        try {
            novoUsuario = new Usuario(
                    null,
                    cadastroRequestDto.nome(),
                    cadastroRequestDto.email(),
                    passwordEncoder.encode(cadastroRequestDto.senha()),
                    TipoAcesso.USUARIO_FINAL,
                    new ArrayList<>(),
                    new ArrayList<>()
            );
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted("senha"));
        } catch (NullPointerException e) {
            String campo = e.getMessage().split(" ")[0];
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted(campo));
        }
        usuarioService.addUsuario(novoUsuario);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(cadastroRequestDto.email(), cadastroRequestDto.senha()));
        return new LoginResponseDto(jwtService.generateToken(novoUsuario));
    }
}
