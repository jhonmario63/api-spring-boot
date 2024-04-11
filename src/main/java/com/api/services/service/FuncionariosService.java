package com.api.services.service;

import com.api.entities.entity.FuncionariosEntity;
import com.api.repositories.IFuncionariosRepository;
import com.api.services.interfaces.FuncionariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosService implements FuncionariosInterface {

    @Autowired
    private IFuncionariosRepository iFuncionariosRepository;

    @Override
    public String postFuncionarios(FuncionariosEntity object) {
        String respuesta;
        Long idfuncionario;
        try {
             idfuncionario= iFuncionariosRepository.save(object).getId();
             if (idfuncionario.describeConstable().isEmpty()){
                 respuesta = "";
             }else{
                 respuesta = "";
             }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            respuesta = ex.getMessage();
        }
        return respuesta;
    }
}
