package com.api.controllers;

import com.api.entities.entity.FuncionariosEntity;
import com.api.repositories.IFuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/v1/funcionarios")
public class FuncionariosController {

    @Autowired
    private IFuncionariosRepository iFuncionariosRepository;

    // Servicio Post para crear un funcionario
    @PostMapping()
    public ResponseEntity<?> postFuncionarios(@RequestBody FuncionariosEntity object) {
        try {
            iFuncionariosRepository.save(object);
            return ResponseEntity.ok("{\"resultado\":\"OK\"}");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":" + ex.getMessage() + ".\"}");
        }
    }

    // Servicio Get para listar los funcionarios
    @GetMapping()
    public ResponseEntity<?> getFuncionariosAll() {
        try {
            return ResponseEntity.ok(iFuncionariosRepository.findAll());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":" + ex.getMessage() + ".\"}");
        }

    }

    // Servicio Get para listar funcionario por ID
    @GetMapping("{id}")
    public ResponseEntity<?> getFuncionariosId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(iFuncionariosRepository.findById(id));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":" + ex.getMessage() + ".\"}");
        }

    }

    // Servicio Put para Actualizar un funcionario por ID
    @PutMapping()
    public ResponseEntity<?> putFuncionarios( @RequestBody FuncionariosEntity object) {
        try {
            Optional<FuncionariosEntity> funcionario = iFuncionariosRepository.findById(object.getId());
            if (funcionario.isPresent()) {
                FuncionariosEntity funcionarioMod = funcionario.get();
                funcionarioMod.setNombres(object.getNombres());
                funcionarioMod.setApellidos(object.getApellidos());
                funcionarioMod.setCelular(object.getCelular());
                funcionarioMod.setEmail(object.getEmail());
                funcionarioMod.setIdentificacion(object.getIdentificacion());
                funcionarioMod.setIdTipoPersona(object.getIdTipoPersona());
                iFuncionariosRepository.save(funcionarioMod);
                return ResponseEntity.ok("{\"resultado\":\"OK\"}");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":" + ex.getMessage() + ".\"}");
        }
    }

}
