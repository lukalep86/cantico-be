// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="user_info_profile")
public class UserInfoProfile implements Serializable {

	private static final long serialVersionUID = 3755745207117150006L;

	/** Primary key. */
    protected static final String PK = "idUserInfoProfile";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user_info_profile", unique=true, nullable=false, precision=19)
    private Long idUserInfoProfile;
    @Column(name="id_user", nullable=false, precision=19)
    private Long idUser;
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
    @Column(name="device_use", length=1)
    private Boolean deviceUse;
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
    @Column(name="community_attendance", length=255)
    private Boolean communityAttendance;
    @Column(length=1024)
    private String hobby;
    @Column(name="cultural_interesting", length=500)
    private String culturalInteresting;
    @Column(name="date_insert")
    private Date dateInsert;
    @Column(name="date_modify")
    private Date dateModify;
    @Column(name="notification_recieved", length=1)
    private Boolean notificationRecieved;
    @Column(name="date_notification_recieved")
    private Date dateNotificationRecieved;
    @Column(name="date_notification_experied")
    private Date dateNotificationExperied;
    @OneToMany(mappedBy="userInfoProfile")
    private Set<Notification> notification;

    /** Default constructor. */
    public UserInfoProfile() {
        super();
    }

    public UserInfoProfile(Long idUserInfoProfile, Long idUser, String gender, Integer age, String maritalStatus,
			String education, String geoLocation, String languages, String employment, String frequenter,
			Boolean deviceUse, String reasonDeviceUse, String eventFrequency, String viewer, String operaType,
			String purchasingOperaItems, Boolean communityAttendance, String hobby, String culturalInteresting,
			Date dateInsert, Date dateModify, Boolean notificationRecieved, Date dateNotificationRecieved,
			Date dateNotificationExperied, Set<Notification> notification) {
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


	/**
     * Access method for idUserInfoProfile.
     *
     * @return the current value of idUserInfoProfile
     */
    public Long getIdUserInfoProfile() {
        return idUserInfoProfile;
    }

    /**
     * Setter method for idUserInfoProfile.
     *
     * @param aIdUserInfoProfile the new value for idUserInfoProfile
     */
    public void setIdUserInfoProfile(Long aIdUserInfoProfile) {
        idUserInfoProfile = aIdUserInfoProfile;
    }

    /**
     * Access method for idUser.
     *
     * @return the current value of idUser
     */
    public Long getIdUser() {
        return idUser;
    }

    /**
     * Setter method for idUser.
     *
     * @param aIdUser the new value for idUser
     */
    public void setIdUser(Long aIdUser) {
        idUser = aIdUser;
    }

    /**
     * Access method for gender.
     *
     * @return the current value of gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Setter method for gender.
     *
     * @param aGender the new value for gender
     */
    public void setGender(String aGender) {
        gender = aGender;
    }

    /**
     * Access method for age.
     *
     * @return the current value of age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Setter method for age.
     *
     * @param aAge the new value for age
     */
    public void setAge(Integer aAge) {
        age = aAge;
    }

    /**
     * Access method for maritalStatus.
     *
     * @return the current value of maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Setter method for maritalStatus.
     *
     * @param aMaritalStatus the new value for maritalStatus
     */
    public void setMaritalStatus(String aMaritalStatus) {
        maritalStatus = aMaritalStatus;
    }

    /**
     * Access method for education.
     *
     * @return the current value of education
     */
    public String getEducation() {
        return education;
    }

    /**
     * Setter method for education.
     *
     * @param aEducation the new value for education
     */
    public void setEducation(String aEducation) {
        education = aEducation;
    }

    /**
     * Access method for geoLocation.
     *
     * @return the current value of geoLocation
     */
    public String getGeoLocation() {
        return geoLocation;
    }

    /**
     * Setter method for geoLocation.
     *
     * @param aGeoLocation the new value for geoLocation
     */
    public void setGeoLocation(String aGeoLocation) {
        geoLocation = aGeoLocation;
    }

    /**
     * Access method for languages.
     *
     * @return the current value of languages
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * Setter method for languages.
     *
     * @param aLanguages the new value for languages
     */
    public void setLanguages(String aLanguages) {
        languages = aLanguages;
    }

    /**
     * Access method for employment.
     *
     * @return the current value of employment
     */
    public String getEmployment() {
        return employment;
    }

    /**
     * Setter method for employment.
     *
     * @param aEmployment the new value for employment
     */
    public void setEmployment(String aEmployment) {
        employment = aEmployment;
    }

    /**
     * Access method for frequenter.
     *
     * @return the current value of frequenter
     */
    public String getFrequenter() {
        return frequenter;
    }

    /**
     * Setter method for frequenter.
     *
     * @param aFrequenter the new value for frequenter
     */
    public void setFrequenter(String aFrequenter) {
        frequenter = aFrequenter;
    }

    /**
     * Access method for deviceUse.
     *
     * @return true if and only if deviceUse is currently true
     */
    public Boolean getDeviceUse() {
        return deviceUse;
    }

    /**
     * Setter method for deviceUse.
     *
     * @param aDeviceUse the new value for deviceUse
     */
    public void setDeviceUse(Boolean aDeviceUse) {
        deviceUse = aDeviceUse;
    }

    /**
     * Access method for reasonDeviceUse.
     *
     * @return the current value of reasonDeviceUse
     */
    public String getReasonDeviceUse() {
        return reasonDeviceUse;
    }

    /**
     * Setter method for reasonDeviceUse.
     *
     * @param aReasonDeviceUse the new value for reasonDeviceUse
     */
    public void setReasonDeviceUse(String aReasonDeviceUse) {
        reasonDeviceUse = aReasonDeviceUse;
    }

    /**
     * Access method for eventFrequency.
     *
     * @return the current value of eventFrequency
     */
    public String getEventFrequency() {
        return eventFrequency;
    }

    /**
     * Setter method for eventFrequency.
     *
     * @param aEventFrequency the new value for eventFrequency
     */
    public void setEventFrequency(String aEventFrequency) {
        eventFrequency = aEventFrequency;
    }

    /**
     * Access method for viewer.
     *
     * @return the current value of viewer
     */
    public String getViewer() {
        return viewer;
    }

    /**
     * Setter method for viewer.
     *
     * @param aViewer the new value for viewer
     */
    public void setViewer(String aViewer) {
        viewer = aViewer;
    }

    /**
     * Access method for operaType.
     *
     * @return the current value of operaType
     */
    public String getOperaType() {
        return operaType;
    }

    /**
     * Setter method for operaType.
     *
     * @param aOperaType the new value for operaType
     */
    public void setOperaType(String aOperaType) {
        operaType = aOperaType;
    }

    /**
     * Access method for purhasingOperaItems.
     *
     * @return the current value of purhasingOperaItems
     */
    public String getPurchasingOperaItems() {
        return purchasingOperaItems;
    }

    /**
     * Setter method for purhasingOperaItems.
     *
     * @param aPurhasingOperaItems the new value for purhasingOperaItems
     */
    public void setPurchasingOperaItems(String aPurchasingOperaItems) {
    	purchasingOperaItems = aPurchasingOperaItems;
    }

    /**
     * Access method for communityAttendance.
     *
     * @return the current value of communityAttendance
     */
    public Boolean getCommunityAttendance() {
        return communityAttendance;
    }

    /**
     * Setter method for communityAttendance.
     *
     * @param aCommunityAttendance the new value for communityAttendance
     */
    public void setCommunityAttendance(Boolean aCommunityAttendance) {
        communityAttendance = aCommunityAttendance;
    }

    /**
     * Access method for hobby.
     *
     * @return the current value of hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * Setter method for hobby.
     *
     * @param aHobby the new value for hobby
     */
    public void setHobby(String aHobby) {
        hobby = aHobby;
    }

    /**
     * Access method for culturalInteresting.
     *
     * @return the current value of culturalInteresting
     */
    public String getCulturalInteresting() {
        return culturalInteresting;
    }

    /**
     * Setter method for culturalInteresting.
     *
     * @param aCulturalInteresting the new value for culturalInteresting
     */
    public void setCulturalInteresting(String aCulturalInteresting) {
        culturalInteresting = aCulturalInteresting;
    }

    /**
     * Access method for dateInsert.
     *
     * @return the current value of dateInsert
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * Setter method for dateInsert.
     *
     * @param aDateInsert the new value for dateInsert
     */
    public void setDateInsert(Date aDateInsert) {
        dateInsert = aDateInsert;
    }

    /**
     * Access method for dateModify.
     *
     * @return the current value of dateModify
     */
    public Date getDateModify() {
        return dateModify;
    }

    /**
     * Setter method for dateModify.
     *
     * @param aDateModify the new value for dateModify
     */
    public void setDateModify(Date aDateModify) {
        dateModify = aDateModify;
    }

    /**
     * Access method for notificationRecieved.
     *
     * @return true if and only if notificationRecieved is currently true
     */
    public Boolean getNotificationRecieved() {
        return notificationRecieved;
    }

    /**
     * Setter method for notificationRecieved.
     *
     * @param aNotificationRecieved the new value for notificationRecieved
     */
    public void setNotificationRecieved(Boolean aNotificationRecieved) {
        notificationRecieved = aNotificationRecieved;
    }

    /**
     * Access method for dateNotificationRecieved.
     *
     * @return the current value of dateNotificationRecieved
     */
    public Date getDateNotificationRecieved() {
        return dateNotificationRecieved;
    }

    /**
     * Setter method for dateNotificationRecieved.
     *
     * @param aDateNotificationRecieved the new value for dateNotificationRecieved
     */
    public void setDateNotificationRecieved(Date aDateNotificationRecieved) {
        dateNotificationRecieved = aDateNotificationRecieved;
    }

    /**
     * Access method for dateNotificationExperied.
     *
     * @return the current value of dateNotificationExperied
     */
    public Date getDateNotificationExperied() {
        return dateNotificationExperied;
    }

    /**
     * Setter method for dateNotificationExperied.
     *
     * @param aDateNotificationExperied the new value for dateNotificationExperied
     */
    public void setDateNotificationExperied(Date aDateNotificationExperied) {
        dateNotificationExperied = aDateNotificationExperied;
    }

    /**
     * Access method for notification.
     *
     * @return the current value of notification
     */
    public Set<Notification> getNotification() {
        return notification;
    }

    /**
     * Setter method for notification.
     *
     * @param aNotification the new value for notification
     */
    public void setNotification(Set<Notification> aNotification) {
        notification = aNotification;
    }

    /**
     * Compares the key for this instance with another UserInfoProfile.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserInfoProfile and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserInfoProfile)) {
            return false;
        }
        UserInfoProfile that = (UserInfoProfile) other;
        if (this.getIdUserInfoProfile() != that.getIdUserInfoProfile()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserInfoProfile.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserInfoProfile)) return false;
        return this.equalKeys(other) && ((UserInfoProfile)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getIdUserInfoProfile() ^ (getIdUserInfoProfile()>>>32));
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[UserInfoProfile |");
        sb.append(" idUserInfoProfile=").append(getIdUserInfoProfile());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("idUserInfoProfile", Long.valueOf(getIdUserInfoProfile()));
        return ret;
    }

}
