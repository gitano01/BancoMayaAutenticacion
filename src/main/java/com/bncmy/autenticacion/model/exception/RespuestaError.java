package com.bncmy.autenticacion.model.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RespuestaError {
	
	private String code;
	private String description;
	private String businessMessage;
	private String reasonPhrase;
	private String uri;
	private String contactEmail;
	private String timeStamp;
	
	public RespuestaError(HttpStatus status, String businessMessage, String reasonPhrase) {
		
		this.code = String.valueOf(status.value());
		this.description = status.getReasonPhrase();
		this.businessMessage = businessMessage;
		this.reasonPhrase = reasonPhrase;
		this.uri = "https://sis.imss.gob.mx/help";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		this.timeStamp = dateFormat.format(new Date());
    }
	
}
