package com.example.clinica.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF, pois não é necessário em APIs REST
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // API sem estado
                .authorizeRequests(authz -> authz
                        .requestMatchers(
                                "/v3/api-docs/**", // Endpoints do Swagger
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/h2-console/**", // Exemplo: H2 Console, se usado
                                "/public/**" // Adicione aqui outras rotas públicas, se necessário
                        ).permitAll() // Permite acesso às rotas acima sem autenticação
                        .anyRequest().permitAll()); // Permite acesso a todas as outras rotas sem autenticação

        return http.build();
    }
}
