package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.exception.NotFoundException;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import com.ablhds.Enemquestions.security.CadastroRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    private PasswordEncoder passwordEncoder;

    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario cadastrarUsuario(CadastroRequestDto cadastroRequestDto, TipoAcesso tipoAcessoUsuario) {
        // TODO: Dar permissões padrão de usuário final
        Usuario novoUsuario;
        try {
            novoUsuario = new Usuario(
                    null,
                    cadastroRequestDto.nome(),
                    cadastroRequestDto.email(),
                    passwordEncoder.encode(cadastroRequestDto.senha()),
                    tipoAcessoUsuario,
                    new ArrayList<>(),
                    new ArrayList<>(),
                    true
            );
        } catch (IllegalArgumentException e) {
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted("senha"));
        } catch (NullPointerException e) {
            String campo = e.getMessage().split(" ")[0];
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted(campo));
        }
        return addUsuario(novoUsuario);
    }

    private Usuario addUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail()))
            throw new BadRequestException(ErrorMessages.USUARIO_EMAIL_EM_USO);
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.USUARIO_NAO_ENCONTRADO));
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(ErrorMessages.USUARIO_EMAIL_INVALIDO));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
    }
}
