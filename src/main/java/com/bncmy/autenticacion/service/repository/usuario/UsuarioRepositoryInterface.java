package com.bncmy.autenticacion.service.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bncmy.autenticacion.model.Usuarios;


public interface UsuarioRepositoryInterface extends JpaRepository<Usuarios, Long >{
	
	public Usuarios findByUsername(String username);

}
