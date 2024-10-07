package com.bncmy.autenticacion.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuarios implements Serializable {

	@Id
	@Column(name="id")
	private Long id;
	@Column(name="username")
	private String username;
	@Column(name="contrasenia")
	private String contrasenia;
	@Column(name="fecha_crea")
	private String fecha_crea;
	@Column(name="fecha_mod")
	private String fecha_mod;	
	@Column(name="cliente_id")
	private Long cliente_id;
	@Column(name="empleado_id")
	private Long empleado_id;
	@Column(name="status")
	private boolean status;
}
