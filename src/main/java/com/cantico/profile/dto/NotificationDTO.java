package com.cantico.profile.dto;

import java.io.Serializable;

public class NotificationDTO implements Serializable{
	
	private static final long serialVersionUID = 5538287669461103878L;
	
	 private Integer idNotificationType;
	 private String description;
	 private Boolean enabled;
	 private Long idUserInfoProfile;
	 
	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotificationDTO(Integer idNotificationType, String description, Boolean enabled,
			Long idUserInfoProfile) {
		super();
		this.idNotificationType = idNotificationType;
		this.description = description;
		this.enabled = enabled;
		this.idUserInfoProfile = idUserInfoProfile;
	}

	public Integer getIdNotificationType() {
		return idNotificationType;
	}

	public void setIdNotificationType(Integer idNotificationType) {
		this.idNotificationType = idNotificationType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Long getIdUserInfoProfile() {
		return idUserInfoProfile;
	}

	public void setIDUserInfoProfile(Long idUserInfoProfile) {
		this.idUserInfoProfile = idUserInfoProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result + ((idNotificationType == null) ? 0 : idNotificationType.hashCode());
		result = prime * result + ((idUserInfoProfile == null) ? 0 : idUserInfoProfile.hashCode());
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
		NotificationDTO other = (NotificationDTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled == null) {
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (idNotificationType == null) {
			if (other.idNotificationType != null)
				return false;
		} else if (!idNotificationType.equals(other.idNotificationType))
			return false;
		if (idUserInfoProfile == null) {
			if (other.idUserInfoProfile != null)
				return false;
		} else if (!idUserInfoProfile.equals(other.idUserInfoProfile))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotificationDTO [idNotificationType=");
		builder.append(idNotificationType);
		builder.append(", description=");
		builder.append(description);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", idUserInfoProfile=");
		builder.append(idUserInfoProfile);
		builder.append("]");
		return builder.toString();
	}
	
}
