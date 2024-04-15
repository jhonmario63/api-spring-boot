package com.api.controllers;

import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.FuncionariosEntity;
import com.api.repositories.IFuncionariosRepository;
import com.api.services.interfaces.FuncionariosInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/v1/funcionarios")
public class FuncionariosController {

    @Autowired
    private IFuncionariosRepository iFuncionariosRepository;

    @Autowired
    private FuncionariosInterface funcionariosInterface;

    // Servicio Post para crear un funcionario
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> postFuncionarios(@RequestBody FuncionariosEntity object) {
        ApiResponse response = funcionariosInterface.postFuncionarios(object);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Servicio Get para listar los funcionarios
    @GetMapping(value = "/all", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getFuncionariosAll() {
        ApiResponse response = funcionariosInterface.getFuncionariosAll();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Servicio Get para listar funcionario por ID
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getFuncionariosId(@RequestParam Long id) {
        ApiResponse response = funcionariosInterface.getFuncionariosId(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // Servicio Put para Actualizar un funcionario por ID
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> putFuncionarios(@RequestBody FuncionariosEntity object) {
        ApiResponse response = funcionariosInterface.putFuncionarios(object);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
