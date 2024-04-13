package com.api.services.service;

import com.api.entities.dto.request.CitasRequest;
import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.CitasEntity;
import com.api.repositories.ICitasRepository;
import com.api.services.interfaces.CitasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CitasService implements CitasInterface {

    @Autowired
    private ICitasRepository citasRepository;

    @Override
    public ApiResponse postImportarCitas(List<CitasRequest> object) {
        try {
            List<CitasEntity> entities = new ArrayList<>();
            for (CitasRequest request : object) {
                CitasEntity entity = new CitasEntity();
                entity.setIdTurno(request.getIdTurno());
                entity.setFechaTurno(request.getFechaTurno());
                entity.setIdentificacion(request.getIdentificacion());
                entity.setTipoIdentificacion(request.getTipoIdentificacion());
                entity.setRazonSocial(request.getRazonSocial());
                entity.setEmail(request.getEmail());
                entity.setCelular(request.getCelular());
                entity.setCiudadResidencia(request.getCiudadResidencia());
                entity.setIdTipoPersona(request.getIdTipoPersona());
                entities.add(entity);
            }
            return new ApiResponse(citasRepository.saveAll(entities), HttpStatus.OK.getReasonPhrase(), HttpStatus.OK.value());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return new ApiResponse(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }
}
