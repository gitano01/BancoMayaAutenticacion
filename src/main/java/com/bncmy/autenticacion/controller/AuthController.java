package com.bncmy.autenticacion.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class AuthController {

	
	@PreAuthorize("permitAll()")
    @PostMapping(value = "/v1/getAccessToken/")
    public ResponseEntity<String> getAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestHeader(name =HttpHeaders.AUTHORIZATION)  String authorizationHeader){
    	
    	return null;
    }
}

