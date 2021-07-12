package com.cantico.profile.dto.mapper;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cantico.profile.dto.NotificationDTO;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.model.Notification;
import com.cantico.profile.model.UserInfoProfile;

public class UserInfoProfileMapper {
	
	public static UserInfoProfileDTO toUserInfoProfileDTO(UserInfoProfile userInfoProfile) {
		
		UserInfoProfileDTO userInfoProfileDTO = new UserInfoProfileDTO();
		
		if(userInfoProfile.getIdUserInfoProfile() != null ) {
			userInfoProfileDTO.setIdUserInfoProfile(userInfoProfile.getIdUserInfoProfile());
		}
		
		userInfoProfileDTO.setAge(userInfoProfile.getAge());
		userInfoProfileDTO.setCommunityAttendance(userInfoProfile.getCommunityAttendance());
		userInfoProfileDTO.setCulturalInteresting(userInfoProfile.getCulturalInteresting());
		userInfoProfileDTO.setDateInsert(userInfoProfile.getDateInsert());
		userInfoProfileDTO.setDeviceUse(userInfoProfile.getDeviceUse());
		userInfoProfileDTO.setEducation(userInfoProfile.getEducation());
		userInfoProfileDTO.setEmployment(userInfoProfile.getEmployment());
		userInfoProfileDTO.setEventFrequency(userInfoProfile.getEventFrequency());
		userInfoProfileDTO.setFrequenter(userInfoProfile.getFrequenter());
		userInfoProfileDTO.setGender(userInfoProfile.getGender());
		userInfoProfileDTO.setGeoLocation(userInfoProfile.getGeoLocation());
		userInfoProfileDTO.setLanguages(userInfoProfile.getLanguages());
		userInfoProfileDTO.setHobby(userInfoProfile.getHobby());
		userInfoProfileDTO.setIdUser(userInfoProfile.getUserAnagrafica().getId());
		userInfoProfileDTO.setMaritalStatus(userInfoProfile.getMaritalStatus());
		userInfoProfileDTO.setNotificationRecieved(userInfoProfile.getNotificationRecieved());
		userInfoProfileDTO.setOperaType(userInfoProfile.getOperaType());
		userInfoProfileDTO.setPurchasingOperaItems(userInfoProfile.getPurchasingOperaItems());
		userInfoProfileDTO.setReasonDeviceUse(userInfoProfile.getReasonDeviceUse());
		userInfoProfileDTO.setViewer(userInfoProfile.getViewer());
		userInfoProfileDTO.setDateInsert(userInfoProfile.getDateInsert());
		userInfoProfileDTO.setDateNotificationExperied(userInfoProfile.getDateNotificationExperied());
		userInfoProfileDTO.setDateNotificationRecieved(userInfoProfile.getDateNotificationRecieved());
		
		Set<Notification> notificationList = userInfoProfile.getNotification();
		Set<NotificationDTO> notificationListDTO = new HashSet<>();
		if(!notificationList.isEmpty()) {
			for(Notification notification : notificationList) {
				NotificationDTO notificationDTO = new NotificationDTO();
				notificationDTO.setIdNotificationType(notification.getIdNotificationType());
				notificationDTO.setDescription(notification.getDescription());
				notificationDTO.setIDUserInfoProfile(notification.getUserInfoProfile().getIdUserInfoProfile());
				notificationDTO.setEnabled(notification.getEnabled());
				notificationListDTO.add(notificationDTO);
			}
		}
		
		userInfoProfileDTO.setNotification(notificationListDTO);
		return userInfoProfileDTO;
	}
	
	public static UserInfoProfile toUserInfoProfile(UserInfoProfileDTO userInfoProfileDTO) {
		
		UserInfoProfile userInfoProfile = new UserInfoProfile();
		
		if(userInfoProfileDTO.getIdUserInfoProfile() != null ) {
			userInfoProfile.setIdUserInfoProfile(userInfoProfileDTO.getIdUserInfoProfile());
		}
		
		userInfoProfile.setAge(userInfoProfileDTO.getAge());
		userInfoProfile.setCommunityAttendance(userInfoProfileDTO.getCommunityAttendance());
		userInfoProfile.setCulturalInteresting(userInfoProfileDTO.getCulturalInteresting());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		userInfoProfile.setDeviceUse(userInfoProfileDTO.getDeviceUse());
		userInfoProfile.setEducation(userInfoProfileDTO.getEducation());
		userInfoProfile.setEmployment(userInfoProfileDTO.getEmployment());
		userInfoProfile.setEventFrequency(userInfoProfileDTO.getEventFrequency());
		userInfoProfile.setFrequenter(userInfoProfileDTO.getFrequenter());
		userInfoProfile.setGender(userInfoProfileDTO.getGender());
		userInfoProfile.setGeoLocation(userInfoProfileDTO.getGeoLocation());
		userInfoProfile.setLanguages(userInfoProfileDTO.getLanguages());
		userInfoProfile.setHobby(userInfoProfileDTO.getHobby());
		userInfoProfile.setMaritalStatus(userInfoProfileDTO.getMaritalStatus());
		userInfoProfile.setNotificationRecieved(userInfoProfileDTO.getNotificationRecieved());
		userInfoProfile.setOperaType(userInfoProfileDTO.getOperaType());
		userInfoProfile.setPurchasingOperaItems(userInfoProfileDTO.getPurchasingOperaItems());
		userInfoProfile.setReasonDeviceUse(userInfoProfileDTO.getReasonDeviceUse());
		userInfoProfile.setViewer(userInfoProfileDTO.getViewer());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		userInfoProfile.setDateModify(userInfoProfileDTO.getDateModify());
		userInfoProfile.setDateNotificationExperied(userInfoProfileDTO.getDateNotificationExperied());
		userInfoProfile.setDateNotificationRecieved(userInfoProfileDTO.getDateNotificationRecieved());
		
		return userInfoProfile;
	}
	
	public static UserInfoProfile updateUserInfoProfileDTO(UserInfoProfile userInfoProfile, UserInfoProfileDTO userInfoProfileDTO) {
		
		if(userInfoProfileDTO.getIdUserInfoProfile() != null ) {
			userInfoProfile.setIdUserInfoProfile(userInfoProfileDTO.getIdUserInfoProfile());
		}
		
		userInfoProfile.setAge(userInfoProfileDTO.getAge());
		userInfoProfile.setCommunityAttendance(userInfoProfileDTO.getCommunityAttendance());
		userInfoProfile.setCulturalInteresting(userInfoProfileDTO.getCulturalInteresting());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		userInfoProfile.setDeviceUse(userInfoProfileDTO.getDeviceUse());
		userInfoProfile.setEducation(userInfoProfileDTO.getEducation());
		userInfoProfile.setEmployment(userInfoProfileDTO.getEmployment());
		userInfoProfile.setEventFrequency(userInfoProfileDTO.getEventFrequency());
		userInfoProfile.setFrequenter(userInfoProfileDTO.getFrequenter());
		userInfoProfile.setGender(userInfoProfileDTO.getGender());
		userInfoProfile.setGeoLocation(userInfoProfileDTO.getGeoLocation());
		userInfoProfile.setLanguages(userInfoProfileDTO.getLanguages());
		userInfoProfile.setHobby(userInfoProfileDTO.getHobby());
		userInfoProfile.setMaritalStatus(userInfoProfileDTO.getMaritalStatus());
		userInfoProfile.setNotificationRecieved(userInfoProfileDTO.getNotificationRecieved());
		userInfoProfile.setOperaType(userInfoProfileDTO.getOperaType());
		userInfoProfile.setPurchasingOperaItems(userInfoProfileDTO.getPurchasingOperaItems());
		userInfoProfile.setReasonDeviceUse(userInfoProfileDTO.getReasonDeviceUse());
		userInfoProfile.setViewer(userInfoProfileDTO.getViewer());
		userInfoProfile.setViewer(userInfoProfileDTO.getViewer());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		userInfoProfile.setDateNotificationExperied(userInfoProfileDTO.getDateNotificationExperied());
		userInfoProfile.setDateNotificationRecieved(userInfoProfileDTO.getDateNotificationRecieved());
		
		return userInfoProfile;
	}

}
