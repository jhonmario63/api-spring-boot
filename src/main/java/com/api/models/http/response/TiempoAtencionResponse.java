package com.api.models.http.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TiempoAtencionResponse implements Serializable {

    private String numTurno;
    private String tipoCliente;
    private String identificacion;
    private String nombreCliente;
    private Integer tiempoGestion;
    private String oficina;
    private String region;
    private String sala;
    private String serMensajeDeRespuesta;
    private Long serNumeroFormulario;
    private String serResultadoDelTramite;
    private String tramite;
    private String usuario;

}
