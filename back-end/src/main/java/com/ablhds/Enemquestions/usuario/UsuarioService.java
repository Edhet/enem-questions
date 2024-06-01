package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.exception.NotFoundException;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import com.ablhds.Enemquestions.security.CadastroRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(CadastroRequestDto cadastroRequestDtoCriptografado, TipoAcesso tipoAcessoUsuario) {
        if (cadastroRequestDtoCriptografado.senha() == null || cadastroRequestDtoCriptografado.senha().isEmpty())
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted("senha"));
        if (cadastroRequestDtoCriptografado.nome() == null || cadastroRequestDtoCriptografado.nome().isEmpty())
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted("nome"));
        if (cadastroRequestDtoCriptografado.email() == null || cadastroRequestDtoCriptografado.email().isEmpty())
            throw new BadRequestException(ErrorMessages.CADASTRO_CAMPO_VAZIO.formatted("email"));

        Pattern checagemEmailValido = Pattern.compile("[a-z0-9]+@[a-z]+\\.[a-z]{2,3}");
        if (!checagemEmailValido.matcher(cadastroRequestDtoCriptografado.email()).matches())
            throw new BadRequestException(ErrorMessages.CADASTRO_EMAIL_INVALIDO);

        // TODO: Dar permissões padrão de usuário final
        Usuario novoUsuario = new Usuario(
                null,
                cadastroRequestDtoCriptografado.nome(),
                cadastroRequestDtoCriptografado.email(),
                cadastroRequestDtoCriptografado.senha(),
                tipoAcessoUsuario,
                new ArrayList<>(),
                new ArrayList<>(),
                true
        );
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
