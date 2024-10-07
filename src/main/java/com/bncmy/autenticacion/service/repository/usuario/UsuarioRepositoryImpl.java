package com.bncmy.autenticacion.service.repository.usuario;

import org.springframework.stereotype.Repository;

import com.bncmy.autenticacion.model.Usuarios;



@Repository
public abstract class UsuarioRepositoryImpl implements UsuarioRepositoryInterface{
	
	public Usuarios findByUsername(String username) {
		return findByUsername(username);
	}

	
	
}
