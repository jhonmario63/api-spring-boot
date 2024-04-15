package com.api.controllers;


import com.api.entities.dto.request.CitasRequest;
import com.api.entities.dto.response.ApiResponse;
import com.api.entities.entity.CitasEntity;
import com.api.repositories.ICitasRepository;
import com.api.services.interfaces.CitasInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/citas")
public class CitasController {

    @Autowired
    private CitasInterface citasInterface;
    @PostMapping(value = "/import", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> saveReporteAll(@RequestBody List<CitasRequest> object) {
        ApiResponse response = citasInterface.postImportarCitas(object);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
