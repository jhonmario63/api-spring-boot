package com.api.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class FuncionariosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombres", length = 255, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 255, nullable = false)
    private String apellidos;

    @Column(name = "identificacion", length = 50, nullable = false, unique = true)
    private String identificacion;

    @Column(name = "celular", length = 255, nullable = true)
    private String celular;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_tipo_tramite") // Nombre de la columna de clave foránea en la tabla tramites_entity
    private TramitesEntity idTipoTramite;

}
