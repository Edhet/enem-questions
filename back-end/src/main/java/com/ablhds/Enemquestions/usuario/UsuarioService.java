package com.ablhds.Enemquestions.usuario;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    public Usuario addUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail()))
            throw new RuntimeException();
        return usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(RuntimeException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Email não encontrado"));
    }
}
