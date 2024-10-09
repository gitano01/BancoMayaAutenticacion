package com.bncmy.autenticacion.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="empleados")
public  class Empleados  {

    @Id
    @Column(name="id")
    private Long id;
    @Column(name="fecha_crea")
    private String fecha_crea;
    @Column(name="fecha_mod")
    private String fecha_mod;
    @Column(name="datospersonales_id")
    private Long datospersonales_id;
    @Column(name="estatus")
    private boolean estatus;
    @Column(name="sucursal_id")
    private Long sucursal_id;
    @Column(name="rol_id")
    private Long rol_id;



}
