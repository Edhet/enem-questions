package com.ablhds.Enemquestions.prova;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/prova")
@AllArgsConstructor
public class ProvaController {
    private final ProvaService provaService;

    @PostMapping("/nova")
    public void novaProva(@Valid @RequestBody ProvaDto provaDto) {
        provaService.addProva(ProvaMapper.dtoToEntity(provaDto));
    }

    @PutMapping("/atualizar")
    public void updateProva(@Valid @RequestBody ProvaDto provaDto) {
        provaService.updateProva(ProvaMapper.dtoToEntity(provaDto));
    }

    @GetMapping("/all")
    public List<ProvaDto> getAllProva() {
        return provaService.findAll().stream().map(ProvaMapper::entityToDto).toList();
    }

    @GetMapping("/{id-prova}")
    public ProvaDto getProva(@PathVariable("id-prova") Long id) {
        return ProvaMapper.entityToDto(provaService.findById(id));
    }

    @DeleteMapping("/{id-prova}")
    public void deleteProva(@PathVariable("id-prova") Long id) {
        provaService.excluirProva(id);
    }
}
