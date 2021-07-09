package com.cantico.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.service.UserInfoProfileService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/userInfo")
@Validated
public class UserInfoProfileController {
	
	@Autowired
	UserInfoProfileService userInfoProfileService;
	
	@PutMapping("/profile/{idUser}")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(@RequestBody UserInfoProfileDTO userInfoProfileDTO, @PathVariable long idUser){
		
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO, idUser);
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserInfoProfileDTO>> getUserInfoProfileList(){
		
		List<UserInfoProfileDTO> userInfoProfileList = userInfoProfileService.getUserInfoProfileList();
		
		return new ResponseEntity<List<UserInfoProfileDTO>>(userInfoProfileList, HttpStatus.OK);
		
	}

}
