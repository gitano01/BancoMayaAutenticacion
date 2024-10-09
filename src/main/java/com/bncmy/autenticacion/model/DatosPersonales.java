package com.bncmy.autenticacion.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="datospersonales")
public class DatosPersonales{

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido_pat")
    private Long apellido_pat;
    @Column(name="apellido_mat")
    private Long apellido_mat;
    @Column(name="estatus")
    private boolean estatus;
    @Column(name="domicilio_id")
    private Long domicilio_id;
    @Column(name="fecha_crea")
    private String fecha_crea;
    @Column(name="fecha_mod")
    private String fecha_mod;
}
