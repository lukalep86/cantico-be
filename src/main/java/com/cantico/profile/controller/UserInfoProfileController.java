package com.cantico.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.service.UserInfoProfileService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/userInfo")
@Validated
public class UserInfoProfileController {
	
	@Autowired
	UserInfoProfileService userInfoProfileService;
	
	@PreAuthorize("isAuthenticated()")
	@PutMapping("/profile")
	public ResponseEntity<UserInfoProfileDTO> createUpdateUserInfoProfile(@RequestBody UserInfoProfileDTO userInfoProfileDTO){
		
		UserInfoProfileDTO userInfoProfile = userInfoProfileService.createUpdateUserInfoProfile(userInfoProfileDTO, 0);
		
		return new ResponseEntity<UserInfoProfileDTO>(userInfoProfile, HttpStatus.OK);
		
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/")
	public ResponseEntity<List<UserInfoProfileDTO>> getUserInfoProfileList(UserInfoProfileDTO userInfoProfileDTO){
		
		List<UserInfoProfileDTO> userInfoProfileList = userInfoProfileService.getUserInfoProfileList();
		
		return new ResponseEntity<List<UserInfoProfileDTO>>(userInfoProfileList, HttpStatus.OK);
		
	}

}
