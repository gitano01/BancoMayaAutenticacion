package com.bncmy.autenticacion.model;

import lombok.Data;

@Data
public class User {
	private String username;
	private String password;
	private int clienteId;
	private int empleadoId;
	private String rol;
	private boolean status;
}
