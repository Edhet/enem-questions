package com.ablhds.Enemquestions;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@AllArgsConstructor
@SpringBootApplication
@EnableCaching
public class EnemQuestionsApplication implements CommandLineRunner {
    private final CargaInicialBanco cargaInicialBanco;

    public static void main(String[] args) {
        SpringApplication.run(EnemQuestionsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cargaInicialBanco.carregar();
    }
}
