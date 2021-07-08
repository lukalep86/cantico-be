// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="notification")
public class Notification implements Serializable {

	private static final long serialVersionUID = -271720270786665108L;

	/** Primary key. */
    protected static final String PK = "idNotificationType";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_notification_type", unique=true, nullable=false, precision=10)
    private Integer idNotificationType;
    @Column(nullable=false, length=255)
    private String description;
    @Column(length=1)
    private Boolean enabled;
    @ManyToOne(optional=false)
    @JoinColumn(name="id_user_info_profile", nullable=false)
    private UserInfoProfile userInfoProfile;

    /** Default constructor. */
    public Notification() {
        super();
    }

    
    public Notification(Integer idNotificationType, String description, Boolean enabled,
			UserInfoProfile userInfoProfile) {
		super();
		this.idNotificationType = idNotificationType;
		this.description = description;
		this.enabled = enabled;
		this.userInfoProfile = userInfoProfile;
	}


	/**
     * Access method for idNotificationType.
     *
     * @return the current value of idNotificationType
     */
    public Integer getIdNotificationType() {
        return idNotificationType;
    }

    /**
     * Setter method for idNotificationType.
     *
     * @param aIdNotificationType the new value for idNotificationType
     */
    public void setIdNotificationType(Integer aIdNotificationType) {
        idNotificationType = aIdNotificationType;
    }

    /**
     * Access method for description.
     *
     * @return the current value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for description.
     *
     * @param aDescription the new value for description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * Access method for enabled.
     *
     * @return true if and only if enabled is currently true
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * Setter method for enabled.
     *
     * @param aEnabled the new value for enabled
     */
    public void setEnabled(Boolean aEnabled) {
        enabled = aEnabled;
    }

    /**
     * Access method for userInfoProfile.
     *
     * @return the current value of userInfoProfile
     */
    public UserInfoProfile getUserInfoProfile() {
        return userInfoProfile;
    }

    /**
     * Setter method for userInfoProfile.
     *
     * @param aUserInfoProfile the new value for userInfoProfile
     */
    public void setUserInfoProfile(UserInfoProfile aUserInfoProfile) {
        userInfoProfile = aUserInfoProfile;
    }

    /**
     * Compares the key for this instance with another Notification.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Notification and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Notification)) {
            return false;
        }
        Notification that = (Notification) other;
        if (this.getIdNotificationType() != that.getIdNotificationType()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Notification.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Notification)) return false;
        return this.equalKeys(other) && ((Notification)other).equalKeys(this);
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
        i = getIdNotificationType();
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
        StringBuffer sb = new StringBuffer("[Notification |");
        sb.append(" idNotificationType=").append(getIdNotificationType());
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
        ret.put("idNotificationType", Integer.valueOf(getIdNotificationType()));
        return ret;
    }

}
