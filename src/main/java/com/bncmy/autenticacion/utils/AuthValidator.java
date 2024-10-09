package com.bncmy.autenticacion.utils;

import java.util.Base64;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.bncmy.autenticacion.model.User;
import com.bncmy.autenticacion.model.exception.ErrorNegocio;
import com.bncmy.autenticacion.model.exception.RespuestaError;

import jakarta.servlet.http.HttpServletRequest;

@Component
public class AuthValidator {
		
	public ResponseEntity<?> validateRequest(HttpServletRequest request) throws Exception{
		
		ResponseEntity<?> response = null;
		
		HttpServletRequest req = request;
		

		try {
			
		//Validar si grant_type esta correcto	ejempl client credentials
		if(req.getParameter("grant_type").isBlank() && req.getParameter("grant_type").isEmpty() ) {
			throw new ErrorNegocio(HttpStatus.BAD_REQUEST,"Operacion Fallida","Falta parametro grant_type"); 
		}
		
		if(!req.getParameter("grant_type").equals("client_credentials")) {
			throw new ErrorNegocio(HttpStatus.BAD_REQUEST,"Operacion Fallida","el parametro grant_type debe ser client_credentials"); 
		}
		
	    //validar si trae el header de authorization en Basic	
		Map<String,String> headers = Collections.list(request.getHeaderNames())
				.stream()
				.collect(Collectors.toMap( h -> h, request::getHeader));
		
		if(!headers.containsKey("Authorization")) {
			throw new ErrorNegocio(HttpStatus.BAD_REQUEST,"Operacion Fallida","Falta header de autorizacion");
		}
		
		byte[] decodedBytes = Base64.getDecoder().decode(headers.get("Authorization").replace("Basic ", "").trim());
		
		String extract = new String(decodedBytes);
		String username = extract.substring(0, extract.indexOf(":"));
		String password = extract.substring( extract.indexOf(":")+1, extract.length());
		
		System.out.println(username);
		System.out.println(password);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
				
		response = new ResponseEntity<>(user,HttpStatus.ACCEPTED);		
		}catch(ErrorNegocio en) {
			int numberHtttpDesired = Integer.parseInt(en.getError().getCode());
			RespuestaError respuestaError = en.getError();
			return new ResponseEntity<>(respuestaError, HttpStatus.valueOf(numberHtttpDesired));
			
		}catch(Exception e) {
			return new ResponseEntity<>("Error interno del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
		
	
}
