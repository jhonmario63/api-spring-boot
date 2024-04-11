package com.api.controllers;


import com.api.entities.entity.CitasEntity;
import com.api.repositories.ICitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/v1/citas")
public class CitasController {

    @Autowired
    private ICitasRepository ICitasRepository;

    @PostMapping("/import")
    public ResponseEntity<?> saveReporteAll(@RequestBody List<CitasEntity> reportes) {
        try {
            ICitasRepository.saveAll(reportes);
            return ResponseEntity.ok("{\"resultado\":\"OK\"}");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"Ocurrió un error al importar.\"}");
        }
    }


//
//    @PostMapping("/resumen")
//    public ResponseEntity<List<ReportesEntity>> findByFechaCreacionBetween(@RequestBody ResumenRequest request) {
//        return ResponseEntity.ok(reportesRepository.findByFechaCreacionBetween(request.getFechaInicial(), request.getFechaFinal()));
//    }
//
//    @PostMapping("/tramite")
//    public ResponseEntity<?> findByCountTramite(@RequestBody ResumenRequest request) {
//        return ResponseEntity.ok(reportesRepositoryNative.findByCountTramite(request));
//    }
//
//    @PostMapping("/estado")
//    public ResponseEntity<?> findByCountEstado(@RequestBody ResumenRequest request) {
//        return ResponseEntity.ok(reportesRepositoryNative.findByCountEstado(request));
//    }
//
//    @PostMapping("/tiempo-atencion")
//    public ResponseEntity<?> findByAllTiempoAtencion(@RequestBody ResumenRequest request) {
//        return ResponseEntity.ok(reportesRepositoryNative.findByAllTiempoAtencion(request));
//    }


}
