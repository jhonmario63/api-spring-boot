package com.api.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "citas", indexes = {
        @Index(name = "idx_fecha_creacion", columnList = "fecha_creacion"),
        @Index(name = "idx_fecha_turno", columnList = "fecha_turno"),
        @Index(name = "idx_id_turno", columnList = "id_turno"),
        @Index(name = "idx_identificacion", columnList = "identificacion")})
public class CitasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idRegistro;

    @Column(name = "id_turno", nullable = false, unique = true)
    private float idTurno;

    @Column(name = "fecha_turno", nullable = false)
    private Timestamp fechaTurno;

    @Column(name = "identificacion", length = 50, nullable = false)
    private String identificacion;

    @Column(name = "tipo_identificacion", length = 50, nullable = false)
    private String tipoIdentificacion;

    @Column(name = "razon_social", length = 255, nullable = false)
    private String razonSocial;

    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @Column(name = "celular", length = 15, nullable = false)
    private String celular;

    @Column(name = "ciudad_residencia", length = 255, nullable = false)
    private String ciudadResidencia;

    @Column(name = "clase_tramite", length = 255, nullable = false)
    private String claseTramite;

    @Column(name = "funcionario", length = 255, nullable = false)
    private String funcionario;

    @Column(name = "email_funcionario", length = 255, nullable = false)
    private String emailFuncionario;

    @Column(name = "fecha_creacion", nullable = false)
    private Timestamp fechaCreacion;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = new Timestamp(System.currentTimeMillis());
    }

}
