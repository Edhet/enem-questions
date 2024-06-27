package com.ablhds.Enemquestions;

import com.ablhds.Enemquestions.permissao.Permissao;
import com.ablhds.Enemquestions.permissao.PermissaoRepository;
import com.ablhds.Enemquestions.usuario.Usuario;
import com.ablhds.Enemquestions.usuario.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ablhds.Enemquestions.permissao.TipoAcesso.*;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class CargaInicialBanco {
    private final static List<Permissao> permissoes = List.of(
            new Permissao("PERMISSAO.SEE_ALL", ADMINISTRADOR),
            new Permissao("PERMISSAO.EDIT_ALL", ADMINISTRADOR),
            new Permissao("PROVA.SEE_ALL", USUARIO_FINAL),
            new Permissao("PROVA.EDIT_ALL", ANALISTA),
            new Permissao("APLICACAO_PROVA.SEE", USUARIO_FINAL),
            new Permissao("APLICACAO_PROVA.EDIT", USUARIO_FINAL)
    );

    private final static Usuario admin = new Usuario(
            null,
            "Admin",
            "admin@ablhds.com",
            "admin",
            ADMINISTRADOR,
            new ArrayList<>(),
            null,
            true
    );

    private final UsuarioRepository usuarioRepository;

    private final PermissaoRepository permissaoRepository;

    private final PasswordEncoder passwordEncoder;

    public void carregar() {
        log.info("{}: {}", "CargaInicial", "Iniciando carga inicial de informações do banco de dados.");
        criarPermissoes();
        criarUsuarioAdmin();
    }

    private void criarPermissoes() {
        int permissoesInalteradas = 0;
        int permissoesAtualizadas = 0;
        int permissoesCriadas = 0;
        for (Permissao permissao : permissoes) {
            Optional<Permissao> permissaoOptional = permissaoRepository.findByAcao(permissao.getAcao());
            if (permissaoOptional.isPresent()) {
                Permissao permissaoAntiga = permissaoOptional.get();
                if (!permissaoAntiga.getAcao().equals(permissao.getAcao())) {
                    permissaoAntiga.setTipoPermissao(permissao.getTipoPermissao());
                    permissaoRepository.save(permissaoAntiga);
                    log.info("{}: {}", "CriarPermissoes", "Permissão %s teve seu tipo alterado.".formatted(permissao.getAcao()));
                    permissoesAtualizadas++;
                    continue;
                }
                permissoesInalteradas++;
                continue;
            }
            permissaoRepository.save(permissao);
            permissoesCriadas++;
        }

        log.info("{}: {}", "CriarPermissoes", "%d novas permissões foram adicionadas, %d foram atualizadas e %d foram inalteradas."
                .formatted(permissoesCriadas, permissoesAtualizadas, permissoesInalteradas)
        );
    }

    private void criarUsuarioAdmin() {
        Optional<Usuario> optionalAdmin = usuarioRepository.findByEmail(admin.getEmail());
        if (optionalAdmin.isPresent()) {
            Usuario admin = optionalAdmin.get();
            admin.setPermissoes(permissaoRepository.findAll());
            usuarioRepository.save(admin);
            log.info("{}: {}", "CriarUsuarioAdmin", "Usuário administrador com todos os privilegios já existe.");
            return;
        }
        admin.setSenha(passwordEncoder.encode(admin.getSenha()));
        admin.setPermissoes(permissaoRepository.findAll());
        usuarioRepository.save(admin);
        log.info("{}: {}", "CriarUsuarioAdmin", "Usuário administrador com todos os privilegios criado com sucesso.");
    }
}
