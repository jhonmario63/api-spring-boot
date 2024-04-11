package com.api.entities.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "citas", indexes = {
        @Index(name = "idx_fecha_creacion", columnList = "fecha_creacion"),
        @Index(name = "idx_fecha_turno", columnList = "fecha_turno"),
        @Index(name = "idx_id_turno", columnList = "id_turno")})
public class CitasEntity  {

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

    @Column(name = "celular", length = 15, nullable = true)
    private String celular;

    @Column(name = "ciudad_residencia", length = 255, nullable = false)
    private String ciudadResidencia;

    @Column(name = "id_tipo_persona", nullable = false)
    private Integer idTipoPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", nullable = true)
    private FuncionariosEntity idFuncionario;

    @Column(name = "fecha_creacion", nullable = false)
    private Timestamp fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = new Timestamp(System.currentTimeMillis());
    }

}
