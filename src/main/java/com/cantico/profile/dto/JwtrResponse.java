package com.cantico.profile.dto;

import java.io.Serializable;
import java.util.List;

public class JwtrResponse implements Serializable{
	
	private static final long serialVersionUID = 1256368862873268984L;
	
	private String jwt;
	private Long idUser;
	private String email;
	
	public JwtrResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtrResponse(String jwt, Long idUser, String email) {
		super();
		this.jwt = jwt;
		this.idUser = idUser;
		this.email = email;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
