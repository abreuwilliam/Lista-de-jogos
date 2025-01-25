package com.devsuperior.dslist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig {

	@Value("${cors.origins}")
	private String corsOrigins;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Use a URL específica para o front-end, se necessário
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:5173", "http://localhost:3000", "https://lista-de-jogos-intensivao-nelio-production.up.railway.app");
			}
		};
	}
}

	