package com.bncmy.autenticacion.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.bncmy.autenticacion.utils.AuthValidator;

@Component
public class InterceptorJwtIO implements HandlerInterceptor{
	
	@Autowired
	AuthValidator validator;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)	throws Exception {
	    ResponseEntity<?> resp = validator.validateRequest(request);
	    boolean validate = false;
	    if(resp.getStatusCode().equals(HttpStatus.ACCEPTED)) {
	    	validate=true;
	    }
	    	
		if(!validate) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		return validate;
		
	}	
}
