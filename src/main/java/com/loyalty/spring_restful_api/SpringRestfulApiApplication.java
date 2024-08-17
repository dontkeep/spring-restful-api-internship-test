package com.loyalty.spring_restful_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringRestfulApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestfulApiApplication.class, args);
	}
}

