
package com.cantico.profile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="user_info_profile")
public class UserInfoProfile implements Serializable {

	private static final long serialVersionUID = 3755745207117150006L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user_info_profile", unique=true, nullable=false, precision=19)
    private Long idUserInfoProfile;
    
    @OneToOne(cascade = javax.persistence.CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private Anagrafica userAnagrafica;
    
    @Column(length=25)
    private String gender;
    
    @Column(precision=10)
    private Integer age;
    
    @Column(name="marital_status", length=45)
    private String maritalStatus;
    
    @Column(length=255)
    private String education;
    
    @Column(name="geo_location", length=255)
    private String geoLocation;
    
    @Column(length=1024)
    private String languages;
    
    @Column(length=255)
    private String employment;
    
    @Column(length=100)
    private String frequenter;
    
    @Column(name="device_use", length=1, columnDefinition = "boolean default false")
    private Boolean deviceUse = false;
    
    @Column(name="reason_device_use", length=255)
    private String reasonDeviceUse;
    
    @Column(name="event_frequency", length=255)
    private String eventFrequency;
    
    @Column(length=255)
    private String viewer;
    
    @Column(name="opera_type", length=1024)
    private String operaType;
    
    @Column(name="purchasing_opera_items", length=1024)
    private String purchasingOperaItems;
    
    @Column(name="community_attendance", length=1, columnDefinition = "boolean default false")
    private Boolean communityAttendance = false;
    
    @Column(length=1024)
    private String hobby;
    
    @Column(name="cultural_interesting", length=500)
    private String culturalInteresting;
    
    @Column(name="date_insert")
    private Date dateInsert;
    
    @Column(name="date_modify")
    private Date dateModify;
    
    @Column(name="notification_recieved", length=1, columnDefinition = "boolean default false")
    private Boolean notificationRecieved = false;
    
    @Column(name="date_notification_recieved")
    private Date dateNotificationRecieved;
    
    @Column(name="date_notification_experied")
    private Date dateNotificationExperied;
    
    @OneToMany(mappedBy="userInfoProfile")
    private Set<Notification> notification;

    public UserInfoProfile() {
        super();
    }

	public UserInfoProfile(Long idUserInfoProfile, Anagrafica userAnagrafica, String gender, Integer age,
			String maritalStatus, String education, String geoLocation, String languages, String employment,
			String frequenter, Boolean deviceUse, String reasonDeviceUse, String eventFrequency, String viewer,
			String operaType, String purchasingOperaItems, Boolean communityAttendance, String hobby,
			String culturalInteresting, Date dateInsert, Date dateModify, Boolean notificationRecieved,
			Date dateNotificationRecieved, Date dateNotificationExperied, Set<Notification> notification) {
		super();
		this.idUserInfoProfile = idUserInfoProfile;
		this.userAnagrafica = userAnagrafica;
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
		this.purchasingOperaItems = purchasingOperaItems;
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

	public Anagrafica getUserAnagrafica() {
		return userAnagrafica;
	}

	public void setUserAnagrafica(Anagrafica userAnagrafica) {
		this.userAnagrafica = userAnagrafica;
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

	public String getPurchasingOperaItems() {
		return purchasingOperaItems;
	}

	public void setPurchasingOperaItems(String purchasingOperaItems) {
		this.purchasingOperaItems = purchasingOperaItems;
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

	public Set<Notification> getNotification() {
		return notification;
	}

	public void setNotification(Set<Notification> notification) {
		this.notification = notification;
	}

    

}
