package com.cantico.profile.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.service.AnagraficaService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	AnagraficaService anagraficaService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Anagrafica user = anagraficaService.findByEmail(email);
		
		if(user == null) {
			throw  new UsernameNotFoundException("User Not Found with username: " + email);
		}
		return UserDetailsImpl.build(user);
	}

}
