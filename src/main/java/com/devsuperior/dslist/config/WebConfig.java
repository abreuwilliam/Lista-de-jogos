package com.devsuperior.dslist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Permitir todas as origens
                        .allowedMethods("*") // Permitir todos os métodos (GET, POST, PUT, DELETE, etc.)
                        .allowedHeaders("*") // Permitir todos os cabeçalhos
                        .exposedHeaders("*") // Expor todos os cabeçalhos
                        .allowCredentials(false); // Credenciais desabilitadas, pois "origem" está como "*"
            }
        };
    }
}
