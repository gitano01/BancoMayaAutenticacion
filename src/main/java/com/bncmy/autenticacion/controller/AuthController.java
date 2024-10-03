package com.bncmy.autenticacion.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping(value="/api")
public class AuthController {

    @PostMapping(value = "/v1/getAccessToken/")
    public ResponseEntity<String> getAccessToken(
            @RequestParam("grant_type") String grantType,
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        
        // Validate the Authorization header
        if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {
            return ResponseEntity.status(401).body("Unauthorized: Missing or invalid Authorization header");
        }

        // Decode the Base64 encoded credentials
        String base64Credentials = authorizationHeader.substring("Basic ".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
        
        // Split the credentials to get username and password
        String[] values = credentials.split(":", 2);
        for(String s : values) {
        	System.out.println(s);
        }
        

        String username = values[0];
        String password = values[1];

        // Validate the username and password
        if (isValidUser(username, password)) {
            return ResponseEntity.ok("Hola mundo");
        } else {
            return ResponseEntity.status(401).body("Unauthorized: Invalid username or password");
        }
    }

    private boolean isValidUser(String username, String password) {
        // Implement your user validation logic here
    	
    	
        return "victor".equals(username) && "demo".equals(password);
    }
}

