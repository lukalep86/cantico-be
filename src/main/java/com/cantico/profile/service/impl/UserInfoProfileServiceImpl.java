package com.cantico.profile.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cantico.profile.dto.NotificationDTO;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.dto.mapper.UserInfoProfileMapper;
import com.cantico.profile.exception.ResourceNotFoundException;
import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.model.Notification;
import com.cantico.profile.model.UserInfoProfile;
import com.cantico.profile.repository.AnagraficaRepository;
import com.cantico.profile.repository.NotificationRepository;
import com.cantico.profile.repository.UserInfoProfileRepository;
import com.cantico.profile.service.UserInfoProfileService;

@Component
public class UserInfoProfileServiceImpl implements UserInfoProfileService{
	
	@Autowired
	UserInfoProfileRepository userInfoProfileRepository;
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	AnagraficaRepository anagraficaRepository;

	@Override
	public UserInfoProfileDTO createUpdateUserInfoProfile(UserInfoProfileDTO userInfoProfileDTO, long idUser) {
		
		Optional<Anagrafica> anagrafica = anagraficaRepository.findById(idUser);
		if(!anagrafica.isPresent()) {
			throw new ResourceNotFoundException("No User Found with id: " + idUser);
		}
		
		Optional<UserInfoProfile> userInfoProfileDb = userInfoProfileRepository.findById(userInfoProfileDTO.getIdUserInfoProfile());
		
		UserInfoProfileDTO userInfoProfileDTOResponse = new UserInfoProfileDTO();
		
		Set<Notification> notificationList = new HashSet<>();
		
		if(userInfoProfileDb.isPresent()) {
			UserInfoProfile userInfoProfileStored = userInfoProfileDb.get();
			UserInfoProfile userProfileUpdate = UserInfoProfileMapper.updateUserInfoProfileDTO(userInfoProfileStored, userInfoProfileDTO);
			if(!userInfoProfileDTO.getNotification().isEmpty()) {
				for(NotificationDTO notification : userInfoProfileDTO.getNotification()) {
					Optional<Notification> notificationUpdateOpt = notificationRepository.findById(notification.getIdNotificationType());
					if(notificationUpdateOpt.isPresent()) {
						Notification notificationUpdate = notificationUpdateOpt.get();
						notificationUpdate.setEnabled(notification.getEnabled());
						notificationList.add(notificationUpdate);
					}
				}
				notificationRepository.saveAll(notificationList);
			}
			userInfoProfileRepository.save(userProfileUpdate);
			
			userProfileUpdate.setNotification(notificationList);
			userInfoProfileDTOResponse= UserInfoProfileMapper.toUserInfoProfileDTO(userProfileUpdate);
			
		}else {
			UserInfoProfile newUserInfoProfile = UserInfoProfileMapper.toUserInfoProfile(userInfoProfileDTO);
			newUserInfoProfile.setUserAnagrafica(anagrafica.get());
			userInfoProfileRepository.save(newUserInfoProfile);
			
			if(!userInfoProfileDTO.getNotification().isEmpty()) {
				for(NotificationDTO notification : userInfoProfileDTO.getNotification()) {
					Notification notificationCreate = new Notification();
					notificationCreate.setDescription(notification.getDescription());
					notificationCreate.setUserInfoProfile(newUserInfoProfile);
					notificationCreate.setEnabled(notification.getEnabled());
					notificationList.add(notificationCreate);
				}
				notificationRepository.saveAll(notificationList);
			}
			
			newUserInfoProfile.setNotification(notificationList);
			userInfoProfileDTOResponse= UserInfoProfileMapper.toUserInfoProfileDTO(newUserInfoProfile);

		}
		return userInfoProfileDTOResponse;
	}

	@Override
	public List<UserInfoProfileDTO> getUserInfoProfileList() {
		
		List<UserInfoProfile> userInfoProfileList = userInfoProfileRepository.findAll();
		List<UserInfoProfileDTO> userInfoProfileDTOList = new ArrayList<>();
		for(UserInfoProfile userInfoProfile : userInfoProfileList) {
			UserInfoProfileDTO userInfoProfileDTO = UserInfoProfileMapper.toUserInfoProfileDTO(userInfoProfile);
			userInfoProfileDTOList.add(userInfoProfileDTO);
		} 
		
		return userInfoProfileDTOList;
	}

}
