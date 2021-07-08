package com.cantico.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cantico.profile.dto.UserInfoProfileDTO;

@Service
public interface UserInfoProfileService {
	
	UserInfoProfileDTO createUpdateUserInfoProfile(UserInfoProfileDTO userInfoProfile, long idUser);
	
	List<UserInfoProfileDTO> getUserInfoProfileList();

}
