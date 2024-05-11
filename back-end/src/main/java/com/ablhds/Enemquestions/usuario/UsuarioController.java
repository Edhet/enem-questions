package com.ablhds.Enemquestions.usuario;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/usuario")
@AllArgsConstructor
public class UsuarioController {

    @GetMapping()
    public boolean check() {
        return true;
    }
}
