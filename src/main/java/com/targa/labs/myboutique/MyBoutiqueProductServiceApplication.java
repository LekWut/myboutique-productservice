package com.targa.labs.myboutique;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableCircuitBreaker
@EnableSwagger2
@SpringBootApplication
public class MyBoutiqueProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoutiqueProductServiceApplication.class, args);
	}
	
}
