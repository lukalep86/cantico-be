package com.cantico.profile.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cantico.profile.dto.SendCustomNotification;
import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.exception.MailAuthenticationException;

@Service
public interface UserInfoProfileService {
	
	UserInfoProfileDTO createUpdateUserInfoProfile(UserInfoProfileDTO userInfoProfile);
	
	List<UserInfoProfileDTO> getUserInfoProfileList();
	
	UserInfoProfileDTO getUserInfoProfileById(long idUserProfile);
	
	List<UserInfoProfileDTO> getUserFilterByAdmin(UserInfoProfileCustomFilter userInfoProfileCustomFilter);

	SendCustomNotification sendNotification(SendCustomNotification sendCustomNotification) throws MailAuthenticationException, ParseException;
}
