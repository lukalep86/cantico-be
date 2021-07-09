package com.cantico.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	 protected void configure(HttpSecurity httpSecurity) throws Exception

	     {
	         httpSecurity.cors().and().csrf().disable().authorizeRequests()
	                 .antMatchers().permitAll()
	                 .anyRequest().authenticated();
	     }

	     @Bean
	     CorsConfigurationSource corsConfigurationSource()
	     {
	         final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	         source.registerCorsConfiguration("/**",new CorsConfiguration().applyPermitDefaultValues());
	         return (CorsConfigurationSource) source;

	     }

}
