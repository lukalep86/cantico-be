package com.cantico.profile.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.cantico.profile.model.Notification;

public class UserInfoProfileDTO implements Serializable{

	private static final long serialVersionUID = 2701329992587393144L;
	
	private Long idUserInfoProfile;
    private Long idUser;
    private String gender;
    private Integer age;
    private String maritalStatus;
    private String education;
    private String geoLocation;
    private String languages;
    private String employment;
    private String frequenter;
    private Boolean deviceUse;
    private String reasonDeviceUse;
    private String eventFrequency;
    private String viewer;
    private String operaType;
    private String purhasingOperaItems;
    private Boolean communityAttendance;
    private String hobby;
    private String culturalInteresting;
    private Date dateInsert;
    private Date dateModify;
    private Boolean notificationRecieved;
    private Date dateNotificationRecieved;
    private Date dateNotificationExperied;
    private Set<NotificationDTO> notification;
    
	public UserInfoProfileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoProfileDTO(Long idUserInfoProfile, Long idUser, String gender, Integer age, String maritalStatus,
			String education, String geoLocation, String languages, String employment, String frequenter,
			Boolean deviceUse, String reasonDeviceUse, String eventFrequency, String viewer, String operaType,
			String purhasingOperaItems, Boolean communityAttendance, String hobby, String culturalInteresting,
			Date dateInsert, Date dateModify, Boolean notificationRecieved, Date dateNotificationRecieved,
			Date dateNotificationExperied, Set<NotificationDTO> notification) {
		super();
		this.idUserInfoProfile = idUserInfoProfile;
		this.idUser = idUser;
		this.gender = gender;
		this.age = age;
		this.maritalStatus = maritalStatus;
		this.education = education;
		this.geoLocation = geoLocation;
		this.languages = languages;
		this.employment = employment;
		this.frequenter = frequenter;
		this.deviceUse = deviceUse;
		this.reasonDeviceUse = reasonDeviceUse;
		this.eventFrequency = eventFrequency;
		this.viewer = viewer;
		this.operaType = operaType;
		this.purhasingOperaItems = purhasingOperaItems;
		this.communityAttendance = communityAttendance;
		this.hobby = hobby;
		this.culturalInteresting = culturalInteresting;
		this.dateInsert = dateInsert;
		this.dateModify = dateModify;
		this.notificationRecieved = notificationRecieved;
		this.dateNotificationRecieved = dateNotificationRecieved;
		this.dateNotificationExperied = dateNotificationExperied;
		this.notification = notification;
	}

	public Long getIdUserInfoProfile() {
		return idUserInfoProfile;
	}

	public void setIdUserInfoProfile(Long idUserInfoProfile) {
		this.idUserInfoProfile = idUserInfoProfile;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getEmployment() {
		return employment;
	}

	public void setEmployment(String employment) {
		this.employment = employment;
	}

	public String getFrequenter() {
		return frequenter;
	}

	public void setFrequenter(String frequenter) {
		this.frequenter = frequenter;
	}

	public Boolean getDeviceUse() {
		return deviceUse;
	}

	public void setDeviceUse(Boolean deviceUse) {
		this.deviceUse = deviceUse;
	}

	public String getReasonDeviceUse() {
		return reasonDeviceUse;
	}

	public void setReasonDeviceUse(String reasonDeviceUse) {
		this.reasonDeviceUse = reasonDeviceUse;
	}

	public String getEventFrequency() {
		return eventFrequency;
	}

	public void setEventFrequency(String eventFrequency) {
		this.eventFrequency = eventFrequency;
	}

	public String getViewer() {
		return viewer;
	}

	public void setViewer(String viewer) {
		this.viewer = viewer;
	}

	public String getOperaType() {
		return operaType;
	}

	public void setOperaType(String operaType) {
		this.operaType = operaType;
	}

	public String getPurhasingOperaItems() {
		return purhasingOperaItems;
	}

	public void setPurhasingOperaItems(String purhasingOperaItems) {
		this.purhasingOperaItems = purhasingOperaItems;
	}

	public Boolean getCommunityAttendance() {
		return communityAttendance;
	}

	public void setCommunityAttendance(Boolean communityAttendance) {
		this.communityAttendance = communityAttendance;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getCulturalInteresting() {
		return culturalInteresting;
	}

	public void setCulturalInteresting(String culturalInteresting) {
		this.culturalInteresting = culturalInteresting;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

	public Date getDateModify() {
		return dateModify;
	}

	public void setDateModify(Date dateModify) {
		this.dateModify = dateModify;
	}

	public Boolean getNotificationRecieved() {
		return notificationRecieved;
	}

	public void setNotificationRecieved(Boolean notificationRecieved) {
		this.notificationRecieved = notificationRecieved;
	}

	public Date getDateNotificationRecieved() {
		return dateNotificationRecieved;
	}

	public void setDateNotificationRecieved(Date dateNotificationRecieved) {
		this.dateNotificationRecieved = dateNotificationRecieved;
	}

	public Date getDateNotificationExperied() {
		return dateNotificationExperied;
	}

	public void setDateNotificationExperied(Date dateNotificationExperied) {
		this.dateNotificationExperied = dateNotificationExperied;
	}

	public Set<NotificationDTO> getNotification() {
		return notification;
	}

	public void setNotification(Set<NotificationDTO> notification) {
		this.notification = notification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((communityAttendance == null) ? 0 : communityAttendance.hashCode());
		result = prime * result + ((culturalInteresting == null) ? 0 : culturalInteresting.hashCode());
		result = prime * result + ((dateInsert == null) ? 0 : dateInsert.hashCode());
		result = prime * result + ((dateModify == null) ? 0 : dateModify.hashCode());
		result = prime * result + ((dateNotificationExperied == null) ? 0 : dateNotificationExperied.hashCode());
		result = prime * result + ((dateNotificationRecieved == null) ? 0 : dateNotificationRecieved.hashCode());
		result = prime * result + ((deviceUse == null) ? 0 : deviceUse.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((employment == null) ? 0 : employment.hashCode());
		result = prime * result + ((eventFrequency == null) ? 0 : eventFrequency.hashCode());
		result = prime * result + ((frequenter == null) ? 0 : frequenter.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((geoLocation == null) ? 0 : geoLocation.hashCode());
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		result = prime * result + ((idUserInfoProfile == null) ? 0 : idUserInfoProfile.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((notification == null) ? 0 : notification.hashCode());
		result = prime * result + ((notificationRecieved == null) ? 0 : notificationRecieved.hashCode());
		result = prime * result + ((operaType == null) ? 0 : operaType.hashCode());
		result = prime * result + ((purhasingOperaItems == null) ? 0 : purhasingOperaItems.hashCode());
		result = prime * result + ((reasonDeviceUse == null) ? 0 : reasonDeviceUse.hashCode());
		result = prime * result + ((viewer == null) ? 0 : viewer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoProfileDTO other = (UserInfoProfileDTO) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (communityAttendance == null) {
			if (other.communityAttendance != null)
				return false;
		} else if (!communityAttendance.equals(other.communityAttendance))
			return false;
		if (culturalInteresting == null) {
			if (other.culturalInteresting != null)
				return false;
		} else if (!culturalInteresting.equals(other.culturalInteresting))
			return false;
		if (dateInsert == null) {
			if (other.dateInsert != null)
				return false;
		} else if (!dateInsert.equals(other.dateInsert))
			return false;
		if (dateModify == null) {
			if (other.dateModify != null)
				return false;
		} else if (!dateModify.equals(other.dateModify))
			return false;
		if (dateNotificationExperied == null) {
			if (other.dateNotificationExperied != null)
				return false;
		} else if (!dateNotificationExperied.equals(other.dateNotificationExperied))
			return false;
		if (dateNotificationRecieved == null) {
			if (other.dateNotificationRecieved != null)
				return false;
		} else if (!dateNotificationRecieved.equals(other.dateNotificationRecieved))
			return false;
		if (deviceUse == null) {
			if (other.deviceUse != null)
				return false;
		} else if (!deviceUse.equals(other.deviceUse))
			return false;
		if (education == null) {
			if (other.education != null)
				return false;
		} else if (!education.equals(other.education))
			return false;
		if (employment == null) {
			if (other.employment != null)
				return false;
		} else if (!employment.equals(other.employment))
			return false;
		if (eventFrequency == null) {
			if (other.eventFrequency != null)
				return false;
		} else if (!eventFrequency.equals(other.eventFrequency))
			return false;
		if (frequenter == null) {
			if (other.frequenter != null)
				return false;
		} else if (!frequenter.equals(other.frequenter))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (geoLocation == null) {
			if (other.geoLocation != null)
				return false;
		} else if (!geoLocation.equals(other.geoLocation))
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		if (idUserInfoProfile == null) {
			if (other.idUserInfoProfile != null)
				return false;
		} else if (!idUserInfoProfile.equals(other.idUserInfoProfile))
			return false;
		if (languages == null) {
			if (other.languages != null)
				return false;
		} else if (!languages.equals(other.languages))
			return false;
		if (maritalStatus == null) {
			if (other.maritalStatus != null)
				return false;
		} else if (!maritalStatus.equals(other.maritalStatus))
			return false;
		if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;
		if (notificationRecieved == null) {
			if (other.notificationRecieved != null)
				return false;
		} else if (!notificationRecieved.equals(other.notificationRecieved))
			return false;
		if (operaType == null) {
			if (other.operaType != null)
				return false;
		} else if (!operaType.equals(other.operaType))
			return false;
		if (purhasingOperaItems == null) {
			if (other.purhasingOperaItems != null)
				return false;
		} else if (!purhasingOperaItems.equals(other.purhasingOperaItems))
			return false;
		if (reasonDeviceUse == null) {
			if (other.reasonDeviceUse != null)
				return false;
		} else if (!reasonDeviceUse.equals(other.reasonDeviceUse))
			return false;
		if (viewer == null) {
			if (other.viewer != null)
				return false;
		} else if (!viewer.equals(other.viewer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfoProfileDTO [idUserInfoProfile=");
		builder.append(idUserInfoProfile);
		builder.append(", idUser=");
		builder.append(idUser);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", age=");
		builder.append(age);
		builder.append(", maritalStatus=");
		builder.append(maritalStatus);
		builder.append(", education=");
		builder.append(education);
		builder.append(", geoLocation=");
		builder.append(geoLocation);
		builder.append(", languages=");
		builder.append(languages);
		builder.append(", employment=");
		builder.append(employment);
		builder.append(", frequenter=");
		builder.append(frequenter);
		builder.append(", deviceUse=");
		builder.append(deviceUse);
		builder.append(", reasonDeviceUse=");
		builder.append(reasonDeviceUse);
		builder.append(", eventFrequency=");
		builder.append(eventFrequency);
		builder.append(", viewer=");
		builder.append(viewer);
		builder.append(", operaType=");
		builder.append(operaType);
		builder.append(", purhasingOperaItems=");
		builder.append(purhasingOperaItems);
		builder.append(", communityAttendance=");
		builder.append(communityAttendance);
		builder.append(", hobby=");
		builder.append(hobby);
		builder.append(", culturalInteresting=");
		builder.append(culturalInteresting);
		builder.append(", dateInsert=");
		builder.append(dateInsert);
		builder.append(", dateModify=");
		builder.append(dateModify);
		builder.append(", notificationRecieved=");
		builder.append(notificationRecieved);
		builder.append(", dateNotificationRecieved=");
		builder.append(dateNotificationRecieved);
		builder.append(", dateNotificationExperied=");
		builder.append(dateNotificationExperied);
		builder.append(", notification=");
		builder.append(notification);
		builder.append("]");
		return builder.toString();
	}

}
