package com.cantico.profile.controller;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.dto.SendCustomNotification;
import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.exception.MailAuthenticationException;
import com.cantico.profile.service.AnagraficaService;
import com.cantico.profile.service.UserInfoProfileService;
import com.cantico.profile.utils.JwtExtractEmail;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/userInfo")
public class UserInfoProfileController {
	
	@Autowired
	UserInfoProfileService userInfoProfileService;
	
	@Autowired
	AnagraficaService anagraficaService;
	
	@Autowired
	JwtExtractEmail jwtExtractEmail;
	
	/*@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(Authentication authentication, @RequestBody @Valid UserInfoProfileDTO userInfoProfileDTO, 
			@RequestHeader(required = false, name = "authorization") String jwt){
		
		String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		Anagrafica authUser = anagraficaService.findByEmail(email);
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO, authUser.getId());
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}*/
	
	//METODO DI TEST
	@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(@RequestBody @Valid UserInfoProfileDTO userInfoProfileDTO){
		
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO);
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@GetMapping("/{idUserProfile}")
	public ResponseEntity<UserInfoProfileDTO> getUserInfoProfileList(@PathVariable("idUserProfile") long idUserProfile/*,
	@RequestHeader(required = false, name = "authorization") String jwt*/){
		
		/*String email = jwtExtractEmail.getPropertyFromToken(jwt, "email");
		Anagrafica authUser = anagraficaService.findByEmail(email);*/
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.getUserInfoProfileById(idUserProfile);
		
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
