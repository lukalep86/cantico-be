package com.cantico.profile.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class SendCustomNotification implements Serializable{

	private static final long serialVersionUID = 2715979081150590559L;
	
	private List<Long> mailTo;
	private String content;
	private Boolean email;
	private Boolean sms;
	private Boolean push;
	private LocalDate eventDate;
	
	public SendCustomNotification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SendCustomNotification(List<Long> mailTo, String content, Boolean email, Boolean sms, Boolean push,
			LocalDate eventDate) {
		super();
		this.mailTo = mailTo;
		this.content = content;
		this.email = email;
		this.sms = sms;
		this.push = push;
		this.eventDate = eventDate;
	}

	public List<Long> getMailTo() {
		return mailTo;
	}

	public void setMailTo(List<Long> mailTo) {
		this.mailTo = mailTo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getEmail() {
		return email;
	}

	public void setEmail(Boolean email) {
		this.email = email;
	}

	public Boolean getSms() {
		return sms;
	}

	public void setSms(Boolean sms) {
		this.sms = sms;
	}

	public Boolean getPush() {
		return push;
	}

	public void setPush(Boolean push) {
		this.push = push;
	}

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((mailTo == null) ? 0 : mailTo.hashCode());
		result = prime * result + ((push == null) ? 0 : push.hashCode());
		result = prime * result + ((sms == null) ? 0 : sms.hashCode());
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
		SendCustomNotification other = (SendCustomNotification) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (mailTo == null) {
			if (other.mailTo != null)
				return false;
		} else if (!mailTo.equals(other.mailTo))
			return false;
		if (push == null) {
			if (other.push != null)
				return false;
		} else if (!push.equals(other.push))
			return false;
		if (sms == null) {
			if (other.sms != null)
				return false;
		} else if (!sms.equals(other.sms))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SendCustomNotification [mailTo=");
		builder.append(mailTo);
		builder.append(", content=");
		builder.append(content);
		builder.append(", email=");
		builder.append(email);
		builder.append(", sms=");
		builder.append(sms);
		builder.append(", push=");
		builder.append(push);
		builder.append(", eventDate=");
		builder.append(eventDate);
		builder.append("]");
		return builder.toString();
	}

}
