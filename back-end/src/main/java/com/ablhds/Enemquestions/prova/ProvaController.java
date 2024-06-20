package com.ablhds.Enemquestions.prova;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prova")
@AllArgsConstructor
public class ProvaController {
    private final ProvaService provaService;

    @PreAuthorize("hasAuthority('PROVA.SEE_ALL')")
    @GetMapping("/all")
    public List<ProvaDto> getAllProva() {
        return provaService.findAll().stream().map(ProvaMapper::entityToDto).toList();
    }

    @PreAuthorize("hasAuthority('PROVA.SEE_ALL')")
    @GetMapping("/{id-prova}")
    public ProvaDto getProva(@PathVariable("id-prova") Long id) {
        return ProvaMapper.entityToDto(provaService.findById(id));
    }

    @PreAuthorize("hasAuthority('PROVA.EDIT_ALL')")
    @PostMapping("/nova")
    public void novaProva(@Valid @RequestBody ProvaDto provaDto) {
        provaService.addProva(ProvaMapper.dtoToEntity(provaDto));
    }

    @PreAuthorize("hasAuthority('PROVA.EDIT_ALL')")
    @PutMapping("/atualizar")
    public void updateProva(@Valid @RequestBody ProvaDto provaDto) {
        provaService.updateProva(ProvaMapper.dtoToEntity(provaDto));
    }

    @PreAuthorize("hasAuthority('PROVA.EDIT_ALL')")
    @DeleteMapping("/{id-prova}")
    public void deleteProva(@PathVariable("id-prova") Long id) {
        provaService.excluirProva(id);
    }
}
