package com.cantico.profile.dto;

import java.io.Serializable;
import java.util.List;

public class UserInfoProfileCustomFilter implements Serializable{

	private static final long serialVersionUID = -5464984728676563312L;
	
	private Integer fromAge; 
	private Integer toAge; 
	private List<String> gender;
	private List<String> maritalStatus; 
	private List<String> education; 
	private String geoLocation; 
	private List<String> employment;
	private List<String> frequenter; 
	private Boolean deviceUse; 
	private List<String> reasonDeviceUse; 
	private List<String> eventFrequency;
	private String viewer; 
	private Boolean communityAttendance; 
	private List<String> hobbies; 
	private List<String> languages; 
	private List<String> culturalInteresting; 
	private List<String> notifications; 
	private List<String> operaType; 
	private List<String> purchasingOperaItems;
	
	public UserInfoProfileCustomFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfoProfileCustomFilter(Integer fromAge, Integer toAge, List<String> gender, List<String> maritalStatus,
			List<String> education, String geoLocation, List<String> employment, List<String> frequenter,
			Boolean deviceUse, List<String> reasonDeviceUse, List<String> eventFrequency, String viewer,
			Boolean communityAttendance, List<String> hobbies, List<String> languages, List<String> culturalInteresting,
			List<String> notifications, List<String> operaType, List<String> purchasingOperaItems) {
		super();
		this.fromAge = fromAge;
		this.toAge = toAge;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.education = education;
		this.geoLocation = geoLocation;
		this.employment = employment;
		this.frequenter = frequenter;
		this.deviceUse = deviceUse;
		this.reasonDeviceUse = reasonDeviceUse;
		this.eventFrequency = eventFrequency;
		this.viewer = viewer;
		this.communityAttendance = communityAttendance;
		this.hobbies = hobbies;
		this.languages = languages;
		this.culturalInteresting = culturalInteresting;
		this.notifications = notifications;
		this.operaType = operaType;
		this.purchasingOperaItems = purchasingOperaItems;
	}

	public Integer getFromAge() {
		return fromAge;
	}

	public void setFromAge(Integer fromAge) {
		this.fromAge = fromAge;
	}

	public Integer getToAge() {
		return toAge;
	}

	public void setToAge(Integer toAge) {
		this.toAge = toAge;
	}

	public List<String> getGender() {
		return gender;
	}

	public void setGender(List<String> gender) {
		this.gender = gender;
	}

	public List<String> getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(List<String> maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public List<String> getEducation() {
		return education;
	}

	public void setEducation(List<String> education) {
		this.education = education;
	}

	public String getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public List<String> getEmployment() {
		return employment;
	}

	public void setEmployment(List<String> employment) {
		this.employment = employment;
	}

	public List<String> getFrequenter() {
		return frequenter;
	}

	public void setFrequenter(List<String> frequenter) {
		this.frequenter = frequenter;
	}

	public Boolean getDeviceUse() {
		return deviceUse;
	}

	public void setDeviceUse(Boolean deviceUse) {
		this.deviceUse = deviceUse;
	}

	public List<String> getReasonDeviceUse() {
		return reasonDeviceUse;
	}

	public void setReasonDeviceUse(List<String> reasonDeviceUse) {
		this.reasonDeviceUse = reasonDeviceUse;
	}

	public List<String> getEventFrequency() {
		return eventFrequency;
	}

	public void setEventFrequency(List<String> eventFrequency) {
		this.eventFrequency = eventFrequency;
	}

	public String getViewer() {
		return viewer;
	}

	public void setViewer(String viewer) {
		this.viewer = viewer;
	}

	public Boolean getCommunityAttendance() {
		return communityAttendance;
	}

	public void setCommunityAttendance(Boolean communityAttendance) {
		this.communityAttendance = communityAttendance;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public List<String> getCulturalInteresting() {
		return culturalInteresting;
	}

	public void setCulturalInteresting(List<String> culturalInteresting) {
		this.culturalInteresting = culturalInteresting;
	}

	public List<String> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}

	public List<String> getOperaType() {
		return operaType;
	}

	public void setOperaType(List<String> operaType) {
		this.operaType = operaType;
	}

	public List<String> getPurchasingOperaItems() {
		return purchasingOperaItems;
	}

	public void setPurchasingOperaItems(List<String> purchasingOperaItems) {
		this.purchasingOperaItems = purchasingOperaItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((communityAttendance == null) ? 0 : communityAttendance.hashCode());
		result = prime * result + ((culturalInteresting == null) ? 0 : culturalInteresting.hashCode());
		result = prime * result + ((deviceUse == null) ? 0 : deviceUse.hashCode());
		result = prime * result + ((education == null) ? 0 : education.hashCode());
		result = prime * result + ((employment == null) ? 0 : employment.hashCode());
		result = prime * result + ((eventFrequency == null) ? 0 : eventFrequency.hashCode());
		result = prime * result + ((frequenter == null) ? 0 : frequenter.hashCode());
		result = prime * result + ((fromAge == null) ? 0 : fromAge.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((geoLocation == null) ? 0 : geoLocation.hashCode());
		result = prime * result + ((hobbies == null) ? 0 : hobbies.hashCode());
		result = prime * result + ((languages == null) ? 0 : languages.hashCode());
		result = prime * result + ((maritalStatus == null) ? 0 : maritalStatus.hashCode());
		result = prime * result + ((notifications == null) ? 0 : notifications.hashCode());
		result = prime * result + ((operaType == null) ? 0 : operaType.hashCode());
		result = prime * result + ((purchasingOperaItems == null) ? 0 : purchasingOperaItems.hashCode());
		result = prime * result + ((reasonDeviceUse == null) ? 0 : reasonDeviceUse.hashCode());
		result = prime * result + ((toAge == null) ? 0 : toAge.hashCode());
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
		UserInfoProfileCustomFilter other = (UserInfoProfileCustomFilter) obj;
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
		if (fromAge == null) {
			if (other.fromAge != null)
				return false;
		} else if (!fromAge.equals(other.fromAge))
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
		if (hobbies == null) {
			if (other.hobbies != null)
				return false;
		} else if (!hobbies.equals(other.hobbies))
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
		if (notifications == null) {
			if (other.notifications != null)
				return false;
		} else if (!notifications.equals(other.notifications))
			return false;
		if (operaType == null) {
			if (other.operaType != null)
				return false;
		} else if (!operaType.equals(other.operaType))
			return false;
		if (purchasingOperaItems == null) {
			if (other.purchasingOperaItems != null)
				return false;
		} else if (!purchasingOperaItems.equals(other.purchasingOperaItems))
			return false;
		if (reasonDeviceUse == null) {
			if (other.reasonDeviceUse != null)
				return false;
		} else if (!reasonDeviceUse.equals(other.reasonDeviceUse))
			return false;
		if (toAge == null) {
			if (other.toAge != null)
				return false;
		} else if (!toAge.equals(other.toAge))
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
		builder.append("UserInfoProfileCustomFilter [fromAge=");
		builder.append(fromAge);
		builder.append(", toAge=");
		builder.append(toAge);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", maritalStatus=");
		builder.append(maritalStatus);
		builder.append(", education=");
		builder.append(education);
		builder.append(", geoLocation=");
		builder.append(geoLocation);
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
		builder.append(", communityAttendance=");
		builder.append(communityAttendance);
		builder.append(", hobbies=");
		builder.append(hobbies);
		builder.append(", languages=");
		builder.append(languages);
		builder.append(", culturalInteresting=");
		builder.append(culturalInteresting);
		builder.append(", notifications=");
		builder.append(notifications);
		builder.append(", operaType=");
		builder.append(operaType);
		builder.append(", purchasingOperaItems=");
		builder.append(purchasingOperaItems);
		builder.append("]");
		return builder.toString();
	}

}
