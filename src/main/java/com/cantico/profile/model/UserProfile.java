// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="user_profile")
public class UserProfile implements Serializable {

    /** Primary key. */
    protected static final String PK = "idUserProfile";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_user_profile", unique=true, nullable=false, precision=19)
    private long idUserProfile;
    @Column(name="id_user", nullable=false, precision=19)
    private long idUser;
    @Column(nullable=false, length=25)
    private String gender;
    @Column(name="marital_status", nullable=false, length=45)
    private String maritalStatus;
    @Column(nullable=false, length=255)
    private String education;
    @Column(name="geo_location", nullable=false, length=255)
    private String geoLocation;
    @Column(nullable=false, length=1024)
    private String languages;
    @Column(nullable=false, length=255)
    private String employment;
    @Column(name="event_frequency", nullable=false, length=100)
    private String eventFrequency;
    @Column(name="device_use", nullable=false, precision=3)
    private short deviceUse;
    @Column(name="reason_device_use", length=500)
    private String reasonDeviceUse;
    @Column(name="date_insert", nullable=false)
    private LocalDateTime dateInsert;
    @Column(name="date_modify")
    private LocalDateTime dateModify;
    @Column(name="notification_recieved", nullable=false, precision=3)
    private short notificationRecieved;
    @Column(name="date_recieved", nullable=false)
    private LocalDateTime dateRecieved;
    @Column(name="date_notification_experied")
    private LocalDateTime dateNotificationExperied;

    /** Default constructor. */
    public UserProfile() {
        super();
    }

    /**
     * Access method for idUserProfile.
     *
     * @return the current value of idUserProfile
     */
    public long getIdUserProfile() {
        return idUserProfile;
    }

    /**
     * Setter method for idUserProfile.
     *
     * @param aIdUserProfile the new value for idUserProfile
     */
    public void setIdUserProfile(long aIdUserProfile) {
        idUserProfile = aIdUserProfile;
    }

    /**
     * Access method for idUser.
     *
     * @return the current value of idUser
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * Setter method for idUser.
     *
     * @param aIdUser the new value for idUser
     */
    public void setIdUser(long aIdUser) {
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
     * Access method for deviceUse.
     *
     * @return the current value of deviceUse
     */
    public short getDeviceUse() {
        return deviceUse;
    }

    /**
     * Setter method for deviceUse.
     *
     * @param aDeviceUse the new value for deviceUse
     */
    public void setDeviceUse(short aDeviceUse) {
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
     * Access method for dateInsert.
     *
     * @return the current value of dateInsert
     */
    public LocalDateTime getDateInsert() {
        return dateInsert;
    }

    /**
     * Setter method for dateInsert.
     *
     * @param aDateInsert the new value for dateInsert
     */
    public void setDateInsert(LocalDateTime aDateInsert) {
        dateInsert = aDateInsert;
    }

    /**
     * Access method for dateModify.
     *
     * @return the current value of dateModify
     */
    public LocalDateTime getDateModify() {
        return dateModify;
    }

    /**
     * Setter method for dateModify.
     *
     * @param aDateModify the new value for dateModify
     */
    public void setDateModify(LocalDateTime aDateModify) {
        dateModify = aDateModify;
    }

    /**
     * Access method for notificationRecieved.
     *
     * @return the current value of notificationRecieved
     */
    public short getNotificationRecieved() {
        return notificationRecieved;
    }

    /**
     * Setter method for notificationRecieved.
     *
     * @param aNotificationRecieved the new value for notificationRecieved
     */
    public void setNotificationRecieved(short aNotificationRecieved) {
        notificationRecieved = aNotificationRecieved;
    }

    /**
     * Access method for dateRecieved.
     *
     * @return the current value of dateRecieved
     */
    public LocalDateTime getDateRecieved() {
        return dateRecieved;
    }

    /**
     * Setter method for dateRecieved.
     *
     * @param aDateRecieved the new value for dateRecieved
     */
    public void setDateRecieved(LocalDateTime aDateRecieved) {
        dateRecieved = aDateRecieved;
    }

    /**
     * Access method for dateNotificationExperied.
     *
     * @return the current value of dateNotificationExperied
     */
    public LocalDateTime getDateNotificationExperied() {
        return dateNotificationExperied;
    }

    /**
     * Setter method for dateNotificationExperied.
     *
     * @param aDateNotificationExperied the new value for dateNotificationExperied
     */
    public void setDateNotificationExperied(LocalDateTime aDateNotificationExperied) {
        dateNotificationExperied = aDateNotificationExperied;
    }

    /**
     * Compares the key for this instance with another UserProfile.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserProfile and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserProfile)) {
            return false;
        }
        UserProfile that = (UserProfile) other;
        if (this.getIdUserProfile() != that.getIdUserProfile()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserProfile.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserProfile)) return false;
        return this.equalKeys(other) && ((UserProfile)other).equalKeys(this);
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
        i = (int)(getIdUserProfile() ^ (getIdUserProfile()>>>32));
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
        StringBuffer sb = new StringBuffer("[UserProfile |");
        sb.append(" idUserProfile=").append(getIdUserProfile());
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
        ret.put("idUserProfile", Long.valueOf(getIdUserProfile()));
        return ret;
    }

}
