package com.cantico.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cantico.profile.utils.ConfigProperties;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableConfigurationProperties(ConfigProperties.class)
@EnableFeignClients
public class CanticoProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanticoProfileApplication.class, args);
	}

}
