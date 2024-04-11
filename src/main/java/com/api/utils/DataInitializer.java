package com.api.utils;

import com.api.entities.entity.TablaGeneralEntity;
import com.api.repositories.ITablaGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private ITablaGeneralRepository iTablaGeneralRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Inserta los registros por defecto
        TablaGeneralEntity entidad1 = new TablaGeneralEntity(1L,true, "tipo de tramite de citas de digiturnos","Inscripción o Actualización RUT Persona Natural",null,null,null);
        TablaGeneralEntity entidad2 = new TablaGeneralEntity(2L,true,"tipo de tramite de citas de digiturnos","Inscripción o Actualización RUT Persona Jurídica",null,null,null);
        iTablaGeneralRepository.saveAll(List.of(entidad1, entidad2));
    }

}
