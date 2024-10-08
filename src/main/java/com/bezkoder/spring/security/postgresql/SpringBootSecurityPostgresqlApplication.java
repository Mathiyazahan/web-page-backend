package com.bezkoder.spring.security.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc
public class SpringBootSecurityPostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityPostgresqlApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE")
	                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
	                        "Access-Control-Request-Headers")
	                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
	                .allowCredentials(true).maxAge(3600);
			}
		};
	}

}
