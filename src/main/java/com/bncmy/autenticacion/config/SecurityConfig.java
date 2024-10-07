//package com.bncmy.autenticacion.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
//            .authorizeRequests(authorizeRequests ->
//                authorizeRequests
//                    .requestMatchers("/bancoMaya/api/v1/getAccessToken/**").permitAll() // Allow access to specific endpoint
//                    .anyRequest().authenticated() // All other requests require authentication
//            );
//
//        return http.build();
//    }
//}
