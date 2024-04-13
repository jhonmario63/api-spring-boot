package com.api.services.service;

import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.FuncionariosEntity;
import com.api.repositories.IFuncionariosRepository;
import com.api.services.interfaces.FuncionariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService implements FuncionariosInterface {

    @Autowired
    private IFuncionariosRepository iFuncionariosRepository;

    @Override
    public ApiResponse postFuncionarios(FuncionariosEntity object) {
        try {
            FuncionariosEntity data = iFuncionariosRepository.save(object);
            return new ApiResponse(data, HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
        } catch (DataIntegrityViolationException ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.CONFLICT.getReasonPhrase(), HttpStatus.CONFLICT.value());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
    @Override
    public ApiResponse getFuncionariosAll() {
        try {
            List<FuncionariosEntity> data = iFuncionariosRepository.findAll();
            return new ApiResponse(data, HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ApiResponse getFuncionariosId(Long id) {
        try {
            Optional<FuncionariosEntity> data = iFuncionariosRepository.findById(id);
            if (data.isPresent()) {
                return new ApiResponse(data, HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
            } else {
                return new ApiResponse(data, HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ApiResponse putFuncionarios(FuncionariosEntity object) {
        try {
            Optional<FuncionariosEntity> data = iFuncionariosRepository.findById(object.getId());
            if (data.isPresent()) {
                FuncionariosEntity funcionarioMod = data.get();
                funcionarioMod.setNombres(object.getNombres());
                funcionarioMod.setApellidos(object.getApellidos());
                funcionarioMod.setCelular(object.getCelular());
                funcionarioMod.setEmail(object.getEmail());
                funcionarioMod.setIdentificacion(object.getIdentificacion());
                funcionarioMod.setIdTipoPersona(object.getIdTipoPersona());
                return new ApiResponse(iFuncionariosRepository.save(funcionarioMod), HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
            } else {
                return new ApiResponse(null, HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT.value());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }


}
