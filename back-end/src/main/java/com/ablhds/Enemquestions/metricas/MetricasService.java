package com.ablhds.Enemquestions.metricas;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MetricasService {
    private final MetricasRepository metricasRepository;

    public Metricas createNewMetricas() {
        Metricas metricas = new Metricas();
        return metricasRepository.save(metricas);
    }

}
