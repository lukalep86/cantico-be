package com.cantico.profile.dto;

import java.io.Serializable;

public class PushNotifyDTO implements Serializable{

	private static final long serialVersionUID = -5383106744042820148L;
	
	private Integer idPushNotify;
	private Long idUserProfile;
	private String content;
	private Boolean checked;
	
	public PushNotifyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PushNotifyDTO(Integer idPushNotify, Long idUserProfile, String content, Boolean checked) {
		super();
		this.idPushNotify = idPushNotify;
		this.idUserProfile = idUserProfile;
		this.content = content;
		this.checked = checked;
	}

	public Integer getIdPushNotify() {
		return idPushNotify;
	}

	public void setIdPushNotify(Integer idPushNotify) {
		this.idPushNotify = idPushNotify;
	}

	public Long getIdUserProfile() {
		return idUserProfile;
	}

	public void setIdUserProfile(Long idUserProfile) {
		this.idUserProfile = idUserProfile;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checked == null) ? 0 : checked.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((idPushNotify == null) ? 0 : idPushNotify.hashCode());
		result = prime * result + ((idUserProfile == null) ? 0 : idUserProfile.hashCode());
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
		PushNotifyDTO other = (PushNotifyDTO) obj;
		if (checked == null) {
			if (other.checked != null)
				return false;
		} else if (!checked.equals(other.checked))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (idPushNotify == null) {
			if (other.idPushNotify != null)
				return false;
		} else if (!idPushNotify.equals(other.idPushNotify))
			return false;
		if (idUserProfile == null) {
			if (other.idUserProfile != null)
				return false;
		} else if (!idUserProfile.equals(other.idUserProfile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushNotifyDTO [idPushNotify=");
		builder.append(idPushNotify);
		builder.append(", idUserProfile=");
		builder.append(idUserProfile);
		builder.append(", content=");
		builder.append(content);
		builder.append(", checked=");
		builder.append(checked);
		builder.append("]");
		return builder.toString();
	}
	

}
