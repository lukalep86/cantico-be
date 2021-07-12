package com.cantico.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class CanticoProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanticoProfileApplication.class, args);
	}

}
