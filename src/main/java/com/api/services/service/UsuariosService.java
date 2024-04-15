package com.api.services.service;

import com.api.entities.entity.UsuariosEntity;
import com.api.repositories.IUsuariosRepository;
import com.api.services.interfaces.UsuariosInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements UsuariosInterfaces {

    @Autowired
    private IUsuariosRepository iUsuariosRepository;

    @Override
    public UsuariosEntity login(String user, String password) {
        return iUsuariosRepository.findByUserAndPasswordAndEstado(user, password, true);
    }

}
