package com.api.models.http.request;

import com.api.models.entity.ReportesEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReporteRequest {
    private List<ReportesEntity> reportesList;
    private Integer idReporte;
    private String nombre;
    private String identificacion;
}
