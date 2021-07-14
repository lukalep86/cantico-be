package com.cantico.profile.cloud.impl;

import java.io.Serializable;

import com.cantico.profile.model.UserInfoProfile;

public class AnagraficaClientCustom implements Serializable{

	private static final long serialVersionUID = 6770541742184976897L;
	
	private Long id;
	private String nome;
	private String cognome;
	private String sesso;
	private String codiceFiscale;
	private String indirizzo;
	private String cap;
	private String stato;
	private String provincia;
	private String comune;
	private String email;
	private String password;
	private String cellulare;
    private UserInfoProfile user;
    
	public AnagraficaClientCustom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnagraficaClientCustom(Long id, String nome, String cognome, String sesso, String codiceFiscale,
			String indirizzo, String cap, String stato, String provincia, String comune, String email, String password,
			String cellulare, UserInfoProfile user) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.stato = stato;
		this.provincia = provincia;
		this.comune = comune;
		this.email = email;
		this.password = password;
		this.cellulare = cellulare;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public UserInfoProfile getUser() {
		return user;
	}

	public void setUser(UserInfoProfile user) {
		this.user = user;
	}

}
