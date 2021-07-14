// Generated with g9.

package com.cantico.profile.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="push_notify")
public class PushNotify implements Serializable {

	private static final long serialVersionUID = -271720270786665108L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_push_notify", unique=true, nullable=false)
    private Integer idPushNotify;
    
    @Column(nullable=false, length=1024)
    private String content;
    
    @Column(length=1)
    private Boolean checked;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_user_info_profile", nullable=false)
    private UserInfoProfile userInfoProfile;
    
    @Column(name = "date_insert")
    private Date dateInsert;

    public PushNotify() {
        super();
    }

	public PushNotify(Integer idPushNotify, String content, Boolean checked, UserInfoProfile userInfoProfile, Date dateInsert) {
		super();
		this.idPushNotify = idPushNotify;
		this.content = content;
		this.checked = checked;
		this.userInfoProfile = userInfoProfile;
		this.dateInsert =  dateInsert;
	}

	public Integer getIdPushNotify() {
		return idPushNotify;
	}

	public void setIdPushNotify(Integer idPushNotify) {
		this.idPushNotify = idPushNotify;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public UserInfoProfile getUserInfoProfile() {
		return userInfoProfile;
	}

	public void setUserInfoProfile(UserInfoProfile userInfoProfile) {
		this.userInfoProfile = userInfoProfile;
	}

	public Date getDateInsert() {
		return dateInsert;
	}

	public void setDateInsert(Date dateInsert) {
		this.dateInsert = dateInsert;
	}

   

}
