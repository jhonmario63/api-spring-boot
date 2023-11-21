package com.api.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reportes", indexes = {
        @Index(name = "idx_fecha_creacion", columnList = "fecha_creacion")})
//@Table(name = "name_table", schema = "schema")
public class ReportesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idRegistro;

    @Column(name = "id_turno", nullable = false)
    private Integer idTurno;

    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @Column(name = "num_turno", length = 255, nullable = true)
    private String numTurno;

    @Column(name = "region", length = 255, nullable = true)
    private String region;

    @Column(name = "fecha_creacion", nullable = true)
    private Timestamp fechaCreacion;

    @Column(name = "oficina", length = 255, nullable = true)
    private String oficina;

    @Column(name = "sala", length = 255, nullable = true)
    private String sala;

    @Column(name = "cliente", length = 255, nullable = true)
    private String cliente;

    @Column(name = "tipo_cliente", length = 255, nullable = true)
    private String tipoCliente;

    @Column(name = "proceso", length = 255, nullable = true)
    private String proceso;

    @Column(name = "subproceso", length = 255, nullable = true)
    private String subproceso;

    @Column(name = "agrupamiento", length = 255, nullable = true)
    private String agrupamiento;

    @Column(name = "tramite", length = 255, nullable = true)
    private String tramite;

    @Column(name = "cola", length = 255, nullable = true)
    private String cola;

    @Column(name = "aniomes", length = 255, nullable = true)
    private String anioMes;

    @Column(name = "hora_solicitud", nullable = true)
    private Time horaSolicitud;

    @Column(name = "hora_fin_espera", nullable = true)
    private Time horaFinEspera;

    @Column(name = "hora_llamado", nullable = true)
    private Time horaLlamado;

    @Column(name = "hora_fin_llamado", nullable = true)
    private Time horaFinLlamado;

    @Column(name = "hora_fin_atencion", nullable = true)
    private Time horaFinAtencion;

    @Column(name = "espera", nullable = true)
    private Time espera;

    @Column(name = "llamado", nullable = true)
    private Time llamado;

    @Column(name = "atencion", nullable = true)
    private Time atencion;

    @Column(name = "total", nullable = true)
    private Time total;

    @Column(name = "usuario", length = 255, nullable = true)
    private String usuario;

    @Column(name = "nombre_usuario", length = 255, nullable = true)
    private String nombreUsuario;

    @Column(name = "terminal", length = 255, nullable = true)
    private String terminal;

    @Column(name = "estado", length = 255, nullable = true)
    private String estado;

    @Column(name = "dia", nullable = true)
    private Integer dia;

    @Column(name = "hora", nullable = true)
    private Integer hora;

    @Column(name = "nombre_cliente", length = 255, nullable = true)
    private String nombreCliente;

    @Column(name = "razon_social", length = 255, nullable = true)
    private String razonSocial;

    @Column(name = "identificacion", length = 255, nullable = true)
    private String identificacion;

    @Column(name = "tipo_identificacion", length = 255, nullable = true)
    private String tipoIdentificacion;

    @Column(name = "ser_inscripcion_rut", length = 255, nullable = true)
    private String serInscripcionRut;

    @Column(name = "ser_numero_formulario", nullable = true)
    private Long serNumeroFormulario;

    @Column(name = "ser_cantidad_folios", nullable = true)
    private Integer serCantidadFolios;

    @Column(name = "ser_resultado_del_tramite", length = 255, nullable = true)
    private String serResultadoDelTramite;

    @Column(name = "ser_gestion_del_caso_a_pst", length = 255, nullable = true)
    private String serGestionDelCasoAPST;

    @Column(name = "ser_observaciones", length = 255, nullable = true)
    private String serObservaciones;

    @Column(name = "ser_tema_de_capacitacion_orientacion", length = 255, nullable = true)
    private String serTemaDeCapacitacionOrientacion;

    @Column(name = "ser_otros_servicios", length = 255, nullable = true)
    private String serOtrosServicios;

    @Column(name = "ser_actualizacion_rut", length = 255, nullable = true)
    private String serActualizacionRut;

    @Column(name = "ser_levantamiento_suspension", length = 255, nullable = true)
    private String serLevantamientoSuspension;

    @Column(name = "ser_objeto_de_campana", length = 255, nullable = true)
    private String serObjetoDeCampana;

    @Column(name = "ser_resultado_cobranzas", length = 255, nullable = true)
    private String serResultadoCobranzas;

    @Column(name = "ser_mensaje_de_respuesta", length = 255, nullable = true)
    private String serMensajeDeRespuesta;

    @Column(name = "tur_tipo_de_identificacion_tramitante", length = 255, nullable = true)
    private String turTipoDeIdentificacionTramitante;

    @Column(name = "tur_clasificacion_tramitante", length = 255, nullable = true)
    private String turClasificacionTramitante;

}
