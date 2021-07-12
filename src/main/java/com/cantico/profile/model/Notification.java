// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;

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

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_notification_type", unique=true, nullable=false)
    private Integer idNotificationType;
    
    @Column(nullable=false, length=255)
    private String description;
    
    @Column(length=1)
    private Boolean enabled;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_user_info_profile", nullable=false)
    private UserInfoProfile userInfoProfile;

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

    public Integer getIdNotificationType() {
        return idNotificationType;
    }

    public void setIdNotificationType(Integer aIdNotificationType) {
        idNotificationType = aIdNotificationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean aEnabled) {
        enabled = aEnabled;
    }

    public UserInfoProfile getUserInfoProfile() {
        return userInfoProfile;
    }

    public void setUserInfoProfile(UserInfoProfile aUserInfoProfile) {
        userInfoProfile = aUserInfoProfile;
    }

}
