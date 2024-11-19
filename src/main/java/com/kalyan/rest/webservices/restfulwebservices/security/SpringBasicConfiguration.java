//package com.kalyan.rest.webservices.restfulwebservices.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
//public class SpringBasicConfiguration {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
//            .authorizeHttpRequests(auth -> auth.antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                .anyRequest().authenticated() // Allow all requests
//            )
//            .httpBasic(Customizer.withDefaults()) // Enable HTTP Basic authentication
//            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session
//            .build();
//    }
//}



