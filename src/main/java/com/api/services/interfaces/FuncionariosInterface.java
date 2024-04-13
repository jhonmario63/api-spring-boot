package com.api.services.interfaces;

import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.FuncionariosEntity;

public interface FuncionariosInterface {

   ApiResponse postFuncionarios(FuncionariosEntity object);
   ApiResponse getFuncionariosAll();
   ApiResponse getFuncionariosId(Long id);
   ApiResponse putFuncionarios(FuncionariosEntity object);

}
