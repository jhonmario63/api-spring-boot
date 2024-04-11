package com.api.entities.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "funcionarios")
public class FuncionariosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombres", length = 128, nullable = false)
    private String nombres;

    @Column(name = "apellidos", length = 128, nullable = false)
    private String apellidos;

    @Column(name = "identificacion", length = 20, nullable = false, unique = true)
    private String identificacion;

    @Column(name = "celular", length = 20, nullable = true)
    private String celular;

    @Column(name = "email", length = 128, nullable = false, unique = true)
    private String email;

    @Column(name = "id_tipo_persona", nullable = false)
    private Integer idTipoPersona;

}
