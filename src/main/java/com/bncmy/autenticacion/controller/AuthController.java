package com.bncmy.autenticacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bncmy.autenticacion.model.Usuarios;
import com.bncmy.autenticacion.service.AuthService;
import com.bncmy.autenticacion.utils.AuthValidator;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/api")
public class AuthController {

	
	@Autowired
	private AuthService service;
	
	
    @PostMapping(value = "/v1/getAccessToken/")
    public ResponseEntity<?> getAccessToken(
            @RequestParam("grant_type") String grantType, @RequestParam("flag") String flag,
            @RequestHeader(name =HttpHeaders.AUTHORIZATION)  String authorizationHeader, HttpServletRequest request) throws Exception{    
    	Usuarios user = (Usuarios) AuthValidator.validateRequest(request).getBody();
    	return service.generateToken(user, flag);
    }
}

