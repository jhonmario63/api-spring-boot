package com.api.utils;

import com.api.models.entity.TramitesEntity;
import com.api.repository.TramitesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private TramitesRepository tramitesRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Inserta los registros por defecto
        TramitesEntity entidad1 = new TramitesEntity(1L, "Inscripción o Actualización RUT Persona Natural");
        TramitesEntity entidad2 = new TramitesEntity(2L, "Inscripción o Actualización RUT Persona Jurídica");
        TramitesEntity entidad3 = new TramitesEntity(3L, "Inscripción o Actualización RUT Persona Natural y/o Jurídica");
        tramitesRepository.saveAll(List.of(entidad1, entidad2, entidad3));
    }

}
