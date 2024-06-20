package com.ablhds.Enemquestions.prova;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvaRepository extends JpaRepository<Prova, Long> {

    List<Prova> findAllByProvaExcluidaFalse();

    Optional<Prova> findAllByIdAndProvaExcluidaFalse(Long id);
}
