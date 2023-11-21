package com.api.controllers;

import com.api.models.entity.ReportesEntity;
import com.api.models.http.request.ResumenRequest;
import com.api.repository.ReportesRepository;
import com.api.repository.ReportesRepositoryNative;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/reportes")
public class ReportesController {

    @Autowired
    private ReportesRepository reportesRepository;

    @Autowired
    private ReportesRepositoryNative reportesRepositoryNative;


    @PostMapping("/saveAll")
    public ResponseEntity<?> saveReporteAll(@RequestBody List<ReportesEntity> reportes) {
        reportesRepository.saveAll(reportes);
        return ResponseEntity.ok("{\"resultado\":\"OK\"}");
    }

    @PostMapping("/resumen")
    public ResponseEntity<List<ReportesEntity>> findByFechaCreacionBetween(@RequestBody ResumenRequest request) {
        return ResponseEntity.ok(reportesRepository.findByFechaCreacionBetween(request.getFechaInicial(),request.getFechaFinal()));
    }

    @PostMapping("/tramite")
    public ResponseEntity<?> findByCountTramite(@RequestBody ResumenRequest request) {
        return ResponseEntity.ok(reportesRepositoryNative.findByCountTramite(request));
    }

    @PostMapping("/estado")
    public ResponseEntity<?> findByCountEstado(@RequestBody ResumenRequest request) {
        return ResponseEntity.ok(reportesRepositoryNative.findByCountEstado(request));
    }

    @PostMapping("/tiempo-atencion")
    public ResponseEntity<?> findByAllTiempoAtencion(@RequestBody ResumenRequest request) {
        return ResponseEntity.ok(reportesRepositoryNative.findByAllTiempoAtencion(request));
    }

}
