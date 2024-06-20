package com.ablhds.Enemquestions.permissao;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/permissao")
@AllArgsConstructor
public class PermissaoController {
    private final PermissaoService permissaoService;

    @PreAuthorize("hasAuthority('PERMISSAO.SEE_ALL')")
    @GetMapping("/all")
    public List<PermissaoDto> findAll() {
        return permissaoService.findAll().stream().map(PermissaoMapper::entityToDto).toList();
    }
}
