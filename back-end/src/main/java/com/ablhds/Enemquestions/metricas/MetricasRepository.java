package com.ablhds.Enemquestions.metricas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricasRepository extends JpaRepository<Metricas, Long> {
}
