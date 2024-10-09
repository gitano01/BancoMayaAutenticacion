package com.bncmy.autenticacion.model.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorNegocio  extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	private RespuestaError error;
	
	public ErrorNegocio(
			HttpStatus status,
			String businessMessage,
			String reasonPhrase) {
		super(reasonPhrase);

		error = new RespuestaError(status, businessMessage, reasonPhrase);
	}

	public ErrorNegocio(RespuestaError error) {
		this.error = error;
	}
	
}
