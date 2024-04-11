package com.api.entities.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tabla_general")
public class TablaGeneralEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estado", nullable = false)
    private boolean estado;

    @Column(name = "descripcion", length = 128, nullable = false)
    private String descripcion;

    @Column(name = "referencia1", length = 128, nullable = true)
    private String referencia1;

    @Column(name = "referencia2", length = 128, nullable = true)
    private String referencia2;

    @Column(name = "referencia3")
    private Integer referencia3;

    @Column(name = "referencia4")
    private Integer referencia4;

}
