package com.cantico.profile.dto.mapper;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.cantico.profile.dto.NotificationDTO;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.model.Notification;
import com.cantico.profile.model.UserInfoProfile;
import com.cantico.profile.utils.StringConcatByArray;

public class UserInfoProfileMapper {
	
	
	
	public static UserInfoProfileDTO toUserInfoProfileDTO(UserInfoProfile userInfoProfile) {
		
		UserInfoProfileDTO userInfoProfileDTO = new UserInfoProfileDTO();
		
		if(userInfoProfile.getIdUserInfoProfile() != null ) {
			userInfoProfileDTO.setIdUserInfoProfile(userInfoProfile.getIdUserInfoProfile());
		}
		
		if(userInfoProfile.getCommunityAttendance() == null) {
			userInfoProfileDTO.setCommunityAttendance(false);
		}else {
			userInfoProfileDTO.setCommunityAttendance(userInfoProfile.getCommunityAttendance());
		}
		
		List<String> culturalInterestingList = new ArrayList<>();
		if(userInfoProfile.getCulturalInteresting() != null) {
			culturalInterestingList = getArryListByArray(userInfoProfile.getCulturalInteresting().trim());
			userInfoProfileDTO.setCulturalInteresting(culturalInterestingList);
		}
		
		userInfoProfileDTO.setAge(userInfoProfile.getAge());
		userInfoProfileDTO.setDateInsert(userInfoProfile.getDateInsert());
		if(userInfoProfile.getDeviceUse() == null) {
			userInfoProfileDTO.setDeviceUse(false);
		}else {
			userInfoProfileDTO.setDeviceUse(userInfoProfile.getDeviceUse());

		}
		userInfoProfileDTO.setEducation(userInfoProfile.getEducation());
		userInfoProfileDTO.setEmployment(userInfoProfile.getEmployment());
		userInfoProfileDTO.setEventFrequency(userInfoProfile.getEventFrequency());
		userInfoProfileDTO.setFrequenter(userInfoProfile.getFrequenter());
		userInfoProfileDTO.setGender(userInfoProfile.getGender());
		userInfoProfileDTO.setGeoLocation(userInfoProfile.getGeoLocation());
		
		List<String> languagesList = new ArrayList<>();
		if(userInfoProfile.getLanguages() != null) {
			languagesList = getArryListByArray(userInfoProfile.getLanguages().trim());
			userInfoProfileDTO.setLanguages(languagesList);
		}
		
		List<String> hobbiesList = new ArrayList<>();
		if(userInfoProfile.getHobby() != null) {
			hobbiesList = getArryListByArray(userInfoProfile.getHobby().trim());
			userInfoProfileDTO.setHobby(hobbiesList);
		}
		userInfoProfileDTO.setIdUser(userInfoProfile.getUserAnagrafica().getId());
		userInfoProfileDTO.setMaritalStatus(userInfoProfile.getMaritalStatus());
		
		if(userInfoProfile.getNotificationRecieved() == null) {
			userInfoProfileDTO.setNotificationRecieved(false);
		}else {
			userInfoProfileDTO.setNotificationRecieved(userInfoProfile.getNotificationRecieved());
		}
		
		List<String> operaTypeList = new ArrayList<>();
		if(userInfoProfile.getOperaType() != null) {
			operaTypeList = getArryListByArray(userInfoProfile.getOperaType().trim());
			userInfoProfileDTO.setOperaType(operaTypeList);
		}
		
		List<String> purchasingOperaTypeList = new ArrayList<>();
		if(userInfoProfile.getPurchasingOperaItems() != null) {
			purchasingOperaTypeList = getArryListByArray(userInfoProfile.getPurchasingOperaItems());
			userInfoProfileDTO.setPurchasingOperaItems(purchasingOperaTypeList);
		}
		
		userInfoProfileDTO.setReasonDeviceUse(userInfoProfile.getReasonDeviceUse());
		userInfoProfileDTO.setViewer(userInfoProfile.getViewer());
		userInfoProfileDTO.setDateModify(userInfoProfile.getDateModify());
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
		
		List<NotificationDTO> orderList = notificationListDTO.stream().sorted(Comparator.comparing(NotificationDTO::getIdNotificationType)).collect(toList());
		notificationListDTO = new LinkedHashSet<>(orderList);
		
		userInfoProfileDTO.setNotifications(notificationListDTO);
		return userInfoProfileDTO;
	}
	
	public static UserInfoProfile toUserInfoProfile(UserInfoProfileDTO userInfoProfileDTO) {
		
		UserInfoProfile userInfoProfile = new UserInfoProfile();
		
		if(userInfoProfileDTO.getIdUserInfoProfile() != null ) {
			userInfoProfile.setIdUserInfoProfile(userInfoProfileDTO.getIdUserInfoProfile());
		}
		
		userInfoProfile.setAge(userInfoProfileDTO.getAge());
		
		if(userInfoProfileDTO.getCommunityAttendance() == null) {
			userInfoProfile.setCommunityAttendance(false);
		}else {
			userInfoProfile.setCommunityAttendance(userInfoProfileDTO.getCommunityAttendance());
		}
		
		if(userInfoProfileDTO.getCulturalInteresting() != null) {
			String culturalInteresting = StringConcatByArray.concatByArray(userInfoProfileDTO.getCulturalInteresting());
			userInfoProfile.setCulturalInteresting(culturalInteresting);
		}
		
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		
		if(userInfoProfileDTO.getDeviceUse() == null) {
			userInfoProfile.setDeviceUse(false);
		}else {
			userInfoProfile.setDeviceUse(userInfoProfileDTO.getDeviceUse());
		}
		
		userInfoProfile.setEducation(userInfoProfileDTO.getEducation());
		userInfoProfile.setEmployment(userInfoProfileDTO.getEmployment());
		userInfoProfile.setEventFrequency(userInfoProfileDTO.getEventFrequency());
		userInfoProfile.setFrequenter(userInfoProfileDTO.getFrequenter());
		userInfoProfile.setGender(userInfoProfileDTO.getGender());
		userInfoProfile.setGeoLocation(userInfoProfileDTO.getGeoLocation());
		
		if(userInfoProfileDTO.getLanguages() != null) {
			String languages = StringConcatByArray.concatByArray(userInfoProfileDTO.getLanguages());
			userInfoProfile.setLanguages(languages);
		}
		
		if(userInfoProfileDTO.getHobby() != null) {
			String hobby = StringConcatByArray.concatByArray(userInfoProfileDTO.getHobby());
			userInfoProfile.setHobby(hobby);
		}
		
		userInfoProfile.setMaritalStatus(userInfoProfileDTO.getMaritalStatus());
		
		if(userInfoProfileDTO.getNotificationRecieved() == null) {
			userInfoProfile.setNotificationRecieved(false);
		}else {
			userInfoProfile.setNotificationRecieved(userInfoProfileDTO.getNotificationRecieved());
		}
		
		if(userInfoProfileDTO.getOperaType() != null) {
			String operaType = StringConcatByArray.concatByArray(userInfoProfileDTO.getOperaType());
			userInfoProfile.setOperaType(operaType);
		}
		
		if(userInfoProfileDTO.getPurchasingOperaItems() != null) {
			String purchasingOperaItems = StringConcatByArray.concatByArray(userInfoProfileDTO.getPurchasingOperaItems());
			userInfoProfile.setPurchasingOperaItems(purchasingOperaItems);
		}
		
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
		
		if(userInfoProfileDTO.getCulturalInteresting() != null) {
			String culturalInteresting = StringConcatByArray.concatByArray(userInfoProfileDTO.getCulturalInteresting());
			userInfoProfile.setCulturalInteresting(culturalInteresting);
		}
		
		userInfoProfile.setAge(userInfoProfileDTO.getAge());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		
		if(userInfoProfileDTO.getDeviceUse() == null) {
			userInfoProfile.setDeviceUse(false);
		}else {
			userInfoProfile.setDeviceUse(userInfoProfileDTO.getDeviceUse());
		}		
		
		userInfoProfile.setEducation(userInfoProfileDTO.getEducation());
		userInfoProfile.setEmployment(userInfoProfileDTO.getEmployment());
		userInfoProfile.setEventFrequency(userInfoProfileDTO.getEventFrequency());
		userInfoProfile.setFrequenter(userInfoProfileDTO.getFrequenter());
		userInfoProfile.setGender(userInfoProfileDTO.getGender());
		userInfoProfile.setGeoLocation(userInfoProfileDTO.getGeoLocation());
		
		if(userInfoProfileDTO.getLanguages() != null) {
			String languages = StringConcatByArray.concatByArray(userInfoProfileDTO.getLanguages());
			userInfoProfile.setLanguages(languages);
		}
		
		if(userInfoProfileDTO.getHobby() != null) {
			String hobby = StringConcatByArray.concatByArray(userInfoProfileDTO.getHobby());
			userInfoProfile.setHobby(hobby);
		}
		
		userInfoProfile.setMaritalStatus(userInfoProfileDTO.getMaritalStatus());
		
		if(userInfoProfileDTO.getNotificationRecieved() == null) {
			userInfoProfile.setNotificationRecieved(false);
		}else {
			userInfoProfile.setNotificationRecieved(userInfoProfileDTO.getNotificationRecieved());
		}
		
		if(userInfoProfileDTO.getOperaType() != null) {
			String operaType = StringConcatByArray.concatByArray(userInfoProfileDTO.getOperaType());
			userInfoProfile.setOperaType(operaType);
		}
			
		if(userInfoProfileDTO.getPurchasingOperaItems() != null) {
			String purchasingOperaItems = StringConcatByArray.concatByArray(userInfoProfileDTO.getPurchasingOperaItems());
			userInfoProfile.setPurchasingOperaItems(purchasingOperaItems);
		}
		
		if(userInfoProfileDTO.getCommunityAttendance() == null) {
			userInfoProfile.setCommunityAttendance(false);
		}else {
			userInfoProfile.setCommunityAttendance(userInfoProfileDTO.getCommunityAttendance());
		}
			
		userInfoProfile.setReasonDeviceUse(userInfoProfileDTO.getReasonDeviceUse());
		userInfoProfile.setViewer(userInfoProfileDTO.getViewer());
		userInfoProfile.setDateInsert(userInfoProfileDTO.getDateInsert());
		userInfoProfile.setDateModify(userInfoProfileDTO.getDateModify());
		userInfoProfile.setDateNotificationExperied(userInfoProfileDTO.getDateNotificationExperied());
		userInfoProfile.setDateNotificationRecieved(userInfoProfileDTO.getDateNotificationRecieved());
		
		return userInfoProfile;
	}
	
	static List<String> getArryListByArray(String object){
		
		List<String> itemList = new ArrayList<>();
		
		String[] items = object.stripTrailing().split(",");
		if(items != null) {
			for(int i = 0; i<items.length; i++) {
				itemList.add(items[i].trim());
			}
		}
		
		return itemList;
	}

}
