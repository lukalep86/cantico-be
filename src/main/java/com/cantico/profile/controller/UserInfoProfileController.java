package com.cantico.profile.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.cloud.AnagraficaClient;
import com.cantico.profile.cloud.impl.AnagraficaClientCustom;
import com.cantico.profile.dto.SendCustomNotification;
import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.exception.MailAuthenticationException;
import com.cantico.profile.service.AnagraficaService;
import com.cantico.profile.service.UserInfoProfileService;
import com.cantico.profile.utils.JwtExtractEmail;

import feign.FeignException;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/userInfo")
public class UserInfoProfileController {
	
	Logger logger = LoggerFactory.getLogger(AnagraficaController.class);
	
	@Autowired
	UserInfoProfileService userInfoProfileService;
	
	@Autowired
	AnagraficaService anagraficaService;
	
	@Autowired
	JwtExtractEmail jwtExtractEmail;
	
	@Autowired
	AnagraficaClient anagraficaClient;
	
	//METODO DA USARE CON AUTH JWT
	/*@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(Authentication authentication, @RequestBody @Valid UserInfoProfileDTO userInfoProfileDTO, 
			@RequestHeader(required = false, name = "authorization") String jwt){
		
		String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		ResponseEntity<AnagraficaClientCustom> anagraficaResponse = null;
		UserInfoProfileDTO userInfoProfile = new UserInfoProfileDTO();
		try {
			anagraficaResponse = anagraficaClient.findAnagrafica(email);
			if (anagraficaResponse.getStatusCode().equals(HttpStatus.OK)) {
				AnagraficaClientCustom body = anagraficaResponse.getBody();
				if (body.getEmail() != null) {
					userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO, body.getId());
				}
			} else {
				throw new RuntimeException(
						String.format("findAnagraficaByEmail status: ", anagraficaResponse.getStatusCode().toString()));
			}

		}catch(FeignException e) {
			logger.error(
					String.format("Errore durante il recupero delle informazioni dell'utente: " + email, e.getMessage()));
			throw new RuntimeException(String.format("Utenti non trovati!", e.getMessage()));

		}
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}*/
	
	//METODO DI TEST SENZA JWT
	@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(@RequestBody @Valid UserInfoProfileDTO userInfoProfileDTO){
		
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO);
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserInfoProfileDTO> getUserInfoProfileList(@PathVariable("email") String email/*,
	@RequestHeader(required = false, name = "authorization") String jwt*/){
		
		/*
		 * JWT jsonExtract
		 * String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
			Anagrafica authUser = anagraficaService.findByEmail(email);*/
		
		UserInfoProfileDTO userInfoProfile = new UserInfoProfileDTO();
		//Use feign-client
		/*ResponseEntity<AnagraficaClientCustom> anagraficaResponse = null;
		try {
			anagraficaResponse = anagraficaClient.findAnagrafica(email);
			if (anagraficaResponse.getStatusCode().equals(HttpStatus.OK)) {
				AnagraficaClientCustom body = anagraficaResponse.getBody();
				if (body.getEmail() != null) {
					userInfoProfile = userInfoProfileService.getUserInfoProfileByUserAnagrafica(anagraficaResponse.getBody());
				}
			} else {
				throw new RuntimeException(
						String.format("findAnagraficaByEmail status: ", anagraficaResponse.getStatusCode().toString()));
			}

		}catch(FeignException e) {
			logger.error(
					String.format("Errore durante il recupero delle informazioni dell'utente: " + email, e.getMessage()));
			throw new RuntimeException(String.format("Utenti non trovati!", e.getMessage()));

		}*/
		
		
		userInfoProfile = userInfoProfileService.getUserInfoProfileByEmail(email);
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@PostMapping("/cluster")
	public ResponseEntity<List<UserInfoProfileDTO>> getUserInfoProfileList(@RequestBody UserInfoProfileCustomFilter userInfoProfileCustomFilter/*,
			@RequestHeader(required = false, name = "authorization") String jwt*/){
		
		/*String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		Anagrafica authUser = anagraficaService.findByEmail(email);*/
		
		List<UserInfoProfileDTO> userInfoProfileList = userInfoProfileService.getUserFilterByAdmin(userInfoProfileCustomFilter);
		
		return new ResponseEntity<List<UserInfoProfileDTO>>(userInfoProfileList, HttpStatus.OK);
		
	}
	
	@PostMapping("/sendNotification")
	public ResponseEntity<SendCustomNotification> sendNotification(@RequestBody SendCustomNotification sendCustomNotification) throws MailAuthenticationException, ParseException{
		
		SendCustomNotification notificationSent = userInfoProfileService.sendNotification(sendCustomNotification);
		
		return new ResponseEntity<SendCustomNotification>(notificationSent, HttpStatus.OK);
	}
	
	

}
