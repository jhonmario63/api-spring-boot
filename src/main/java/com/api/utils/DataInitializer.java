package com.api.utils;

import com.api.entities.entity.TablaGeneralEntity;
import com.api.entities.entity.UsuariosEntity;
import com.api.repositories.ITablaGeneralRepository;
import com.api.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements ApplicationRunner {
    @Autowired
    private ITablaGeneralRepository iTablaGeneralRepository;

    @Autowired
    private IUsuariosRepository iUsuariosRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Inserta los registros por defecto
        TablaGeneralEntity item1 = new TablaGeneralEntity(1L,true, "tipo de tramite de citas de digiturnos","Inscripción o Actualización RUT Persona Natural",null,null,null);
        TablaGeneralEntity item2 = new TablaGeneralEntity(2L,true,"tipo de tramite de citas de digiturnos","Inscripción o Actualización RUT Persona Jurídica",null,null,null);
        iTablaGeneralRepository.saveAll(List.of(item1, item2));

        UsuariosEntity item3 = new UsuariosEntity(1L,true,"Administrador","Administrador","admin","123456",null);
        iUsuariosRepository.save(item3);

    }

}
