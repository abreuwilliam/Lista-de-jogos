package com.devsuperior.dslist.config;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.web.servlet.config.annotation.CorsRegistry;
	import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.Filter;
import jakarta.servlet.http.HttpServletResponse;

	
	@Configuration
	public class WebConfig {
	
		@Bean
		public WebMvcConfigurer corsConfigurer() {
			return new WebMvcConfigurer() {
				@Override
				public void addCorsMappings(CorsRegistry registry) {
					registry.addMapping("/**")
							.allowedMethods("*")
							.allowedOrigins(
									"http://localhost:5173",
									"http://localhost:3000",
									"https://lista-de-jogos-intensivao-nelio-production.up.railway.app","https://beautiful-raindrop-8b81ce.netlify.app"
							)
							.allowedHeaders("*")
							.exposedHeaders("Content-Type", "Authorization")
							.allowCredentials(true);
				}
			};
		}
	
		@Bean
		public Filter corsFilter() {
			return (request, response, chain) -> {
				HttpServletResponse res = (HttpServletResponse) response;
				res.setHeader("Access-Control-Allow-Origin", "https://lista-de-jogos-intensivao-nelio-production.up.railway.app");
				res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
				res.setHeader("Access-Control-Allow-Headers", "*");
				res.setHeader("Access-Control-Allow-Credentials", "true");
				chain.doFilter(request, response);
			};
		}
	}
	


	