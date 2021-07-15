package com.cantico.profile.controller;

import java.text.ParseException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.cloud.AnagraficaClient;
import com.cantico.profile.cloud.impl.AnagraficaClientCustom;
import com.cantico.profile.dto.SendCustomNotification;
import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.exception.MailAuthenticationException;
import com.cantico.profile.service.UserInfoProfileService;
import com.cantico.profile.utils.JwtExtractEmail;

import feign.FeignException;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/userInfo")
public class UserInfoProfileController {
	
	Logger logger = LoggerFactory.getLogger(UserInfoProfileController.class);
	
	@Autowired
	UserInfoProfileService userInfoProfileService;
	
	@Autowired
	JwtExtractEmail jwtExtractEmail;
	
	@Autowired
	AnagraficaClient anagraficaClient;
	
	
	@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(@RequestBody @Valid UserInfoProfileDTO userInfoProfileDTO, 
			@RequestHeader(required = false, name = "authorization") String jwt){
		
		logger.info("init method in UserInfoProfileController: createUpdateUserInfoProfile");
		
		//String email = jwtExtractEmail.getPropertyFromToken(jwt, "email"); //DECOMMENTATE QUANDO SI USA IL JWT AUTH
		ResponseEntity<AnagraficaClientCustom> anagraficaResponse = null;
		UserInfoProfileDTO userInfoProfile = new UserInfoProfileDTO();
		try {
			//anagraficaResponse = anagraficaClient.findAnagrafica(email);  DECOMMENTARE QUANDO SI USA IL JWT AUTH
			anagraficaResponse = anagraficaClient.findAnagrafica(userInfoProfileDTO.getEmail()); //COMMENTARE QUANDO SI USA IL JWT
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
					String.format("Errore durante il recupero delle informazioni dell'utente: " + userInfoProfileDTO.getEmail(), e.getMessage()));
			throw new RuntimeException(String.format("Utente non trovati!", e.getMessage()));

		}
		
		logger.info("end method in UserInfoProfileController: createUpdateUserInfoProfile");
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<UserInfoProfileDTO> getUserInfoProfileList(@PathVariable("email") String email,
	@RequestHeader(required = false, name = "authorization") String jwt){
		
		logger.info("init method in UserInfoProfileController: getUserInfoProfileList");

		//NB: nel caso in cui viene utilizzato il Jwt, decommentare la string sottostanste e togliere il "@PathVariable("email") String email"
		//		oltre a togliere {email} dal path
		//String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		UserInfoProfileDTO userInfoProfile = new UserInfoProfileDTO();
		ResponseEntity<AnagraficaClientCustom> anagraficaResponse = null;
		try {
			anagraficaResponse = anagraficaClient.findAnagrafica(email);
			if (anagraficaResponse.getStatusCode().equals(HttpStatus.OK)) {
				AnagraficaClientCustom body = anagraficaResponse.getBody();
				if (body.getEmail() != null) {
					userInfoProfile = userInfoProfileService.getUserInfoProfileByUserAnagrafica(anagraficaResponse.getBody());
				}
			} 

		}catch(FeignException e) {
			logger.error(
					String.format("Errore durante il recupero delle informazioni dell'utente: " + email, e.getMessage()));
			throw new RuntimeException(String.format("Utente non trovati!", e.getMessage()));

		}

		logger.info("end method in UserInfoProfileController: getUserInfoProfileList");
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@PostMapping("/cluster")
	public ResponseEntity<List<UserInfoProfileDTO>> getUserInfoProfileList(@RequestBody UserInfoProfileCustomFilter userInfoProfileCustomFilter,
			@RequestHeader(required = false, name = "authorization") String jwt){
		
		logger.info("init method in UserInfoProfileController: getUserInfoProfileList");

		List<UserInfoProfileDTO> userInfoProfileList = new ArrayList<>();
		/*String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		ResponseEntity<AnagraficaClientCustom> anagraficaResponse = null;
		try {
			anagraficaResponse = anagraficaClient.findAnagrafica(email);
			if (anagraficaResponse.getStatusCode().equals(HttpStatus.OK)) {
				AnagraficaClientCustom body = anagraficaResponse.getBody();
				if (body.getEmail() != null) {
					userInfoProfileList = userInfoProfileService.getUserFilterByAdmin(userInfoProfileCustomFilter);
				}
			} 

		}catch(FeignException e) {
			logger.error(
					String.format("Errore durante il recupero delle informazioni dell'utente: " + email, e.getMessage()));
					throw new RuntimeException(String.format("Utenti non trovati!", e.getMessage()));
		}*/
		
		userInfoProfileList = userInfoProfileService.getUserFilterByAdmin(userInfoProfileCustomFilter);
		logger.info("end method in UserInfoProfileController: getUserInfoProfileList");
		return new ResponseEntity<List<UserInfoProfileDTO>>(userInfoProfileList, HttpStatus.OK);
		
	}
	
	@PostMapping("/sendNotification")
	public ResponseEntity<SendCustomNotification> sendNotification(@RequestBody SendCustomNotification sendCustomNotification) throws MailAuthenticationException, ParseException{
		
		logger.info("init method in UserInfoProfileController: sendNotification");

		SendCustomNotification notificationSent = userInfoProfileService.sendNotification(sendCustomNotification);
		
		logger.info("end method in UserInfoProfileController: sendNotification");
		return new ResponseEntity<SendCustomNotification>(notificationSent, HttpStatus.OK);
	}
	
	

}
