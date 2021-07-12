package com.cantico.profile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.cantico.profile.utils.Unique;

/**
 * The persistent class for the "Anagrafica" database table.
 * 
 */
@Entity
@Table(name = "\"Anagrafica\"")
public class Anagrafica  {

	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique=true,	nullable = false)
	private Long id;

	
	@Column(name ="nome")
	private String nome;
	@Column(name ="cognome")
	private String cognome;
	@Column(name ="sesso")
	private String sesso;
	@Pattern(regexp="^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$|^$", message="malformed code")  
	@Column(name ="codiceFiscale", nullable = true)
	private String codiceFiscale;
	@Column(name ="indirizzo")
	private String indirizzo;
	@Column(name ="cap")
	private String cap;
	@Column(name ="stato")
	private String stato;
	@Column(name ="provincia")
	private String provincia;
	@Column(name ="comune")
	private String comune;
	@Column(name="email", unique=true,	nullable = false)
	@NotBlank(message = "Email non può essere vuota")
	@NotNull(message="Email è un campo obbligatorio.")
	@Email(message = "Formato email non valido")
	@Unique(message="Email esistente")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="cellulare")
	private String cellulare;
	@OneToOne(mappedBy = "userAnagrafica")
    private UserInfoProfile user;
	@OneToOne(cascade = CascadeType.ALL)
	private DettagliTecnici details;

	public Anagrafica(){

	}

	public Anagrafica(String name, String cognome, String sesso, String codiceFiscale, String indirizzo, 
		String cap, String stato, String provincia, String comune, String email, String psw, String cellulare, DettagliTecnici details) {
		
		super();
		this.nome= name;
		this.cognome = cognome;
		this.sesso = sesso;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.stato = stato;
		this.provincia=provincia;
		this.comune= comune;
		this.email = email;
		this.password = psw;
		this.cellulare = cellulare;
		this.details = details;
	

	}


	public Anagrafica(Long id, String nome, String cognome, String sesso,
			@Pattern(regexp = "^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$|^$", message = "malformed code") String codiceFiscale,
			String indirizzo, String cap, String stato, String provincia, String comune,
			@NotBlank(message = "Email non può essere vuota") @NotNull(message = "Email è un campo obbligatorio.") @Email(message = "Formato email non valido") String email,
			String password, String cellulare, UserInfoProfile user, DettagliTecnici details) {
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
		this.details = details;
	}

	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	
	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DettagliTecnici getDetails() {
        return details;
    }

    public void setDetails(DettagliTecnici details) {
        this.details = details;
        
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellulare() {
		return cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}