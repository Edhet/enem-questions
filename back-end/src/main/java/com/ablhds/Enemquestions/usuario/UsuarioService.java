package com.ablhds.Enemquestions.usuario;

import com.ablhds.Enemquestions.exception.BadRequestException;
import com.ablhds.Enemquestions.exception.ErrorMessages;
import com.ablhds.Enemquestions.exception.NotFoundException;
import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.PermissaoService;
import com.ablhds.Enemquestions.permissao.TipoAcesso;
import com.ablhds.Enemquestions.security.CadastroRequestDto;
import com.ablhds.Enemquestions.security.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    private final JwtService jwtService;

    private final PermissaoService permissaoService;

    public Usuario addUsuario(CadastroRequestDto cadastroRequestDtoCriptografado, TipoAcesso tipoAcessoUsuario) {
        List<Permissao> permissoesUsarioFinal = permissaoService.findPermissoesPorTipoAcesso(TipoAcesso.USUARIO_FINAL);

        Usuario novoUsuario = new Usuario(
                null,
                cadastroRequestDtoCriptografado.nome(),
                cadastroRequestDtoCriptografado.email(),
                cadastroRequestDtoCriptografado.senha(),
                tipoAcessoUsuario,
                permissoesUsarioFinal,
                new ArrayList<>(),
                true
        );
        if (usuarioRepository.existsByEmail(novoUsuario.getEmail()))
            throw new BadRequestException(ErrorMessages.USUARIO_EMAIL_EM_USO);
        return usuarioRepository.save(novoUsuario);
    }

    public UsuarioDto getInformacoesDoUsuario(String authHeader) {
        return UsuarioMapper.entityToDto(findByAuthHeader(authHeader));
    }

    public void desativarConta(String authHeader) {
        Usuario usuario = findByAuthHeader(authHeader);
        if (!usuario.getContaAtiva())
            throw new BadRequestException(ErrorMessages.CONTA_DESATIVADA);
        usuario.setContaAtiva(false);
    }

    public void ativarConta(Usuario usuario) {
        if (usuario.getContaAtiva())
            throw new BadRequestException(ErrorMessages.CONTA_ATIVADA);
        usuario.setContaAtiva(true);
    }

    public Usuario findByAuthHeader(String authHeader) {
        return findByToken(jwtService.getTokenFromAuthHeader(authHeader));
    }

    public Usuario findByToken(String token) {
        String emailUsuario = jwtService.extractEmail(token);
        return findByEmail(emailUsuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException(ErrorMessages.USUARIO_NAO_ENCONTRADO));
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new BadRequestException(ErrorMessages.USUARIO_NAO_ENCONTRADO));
    }

    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void darPermissao(String email, Permissao permissao) {
        Usuario usuario = findByEmail(email);
        usuario.getPermissoes().add(permissao);
        usuarioRepository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
    }
}
