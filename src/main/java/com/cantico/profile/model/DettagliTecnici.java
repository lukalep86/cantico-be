package com.cantico.profile.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="\"Dettagli_Tecnici\"")
public class DettagliTecnici {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
 

    @Column(name = "one_time_password")
    private String oneTimePassword;
    @Column(name = "otp_requested_time")
    private Date otpRequestTime;
    @Column(name = "is_enabled")
    private boolean isEnabled; //se ha sottomesso codice OTP, utente abilitato (registrato)
    @Column(name = "canale_comunicazione")
    private String canale_comunicazione;
    @Column(name="frequenza")
    private String frequenza; // settimanale/mensile
    @Column(name="consenso")
    private boolean consenso; //se true i campi canale_comunicazione e frequenza sono required
 
 
    public DettagliTecnici() {}
 
 
    public DettagliTecnici(String oneTimePassword, Date otpRequestTime, Boolean isEnable, String canaleComunicazione, String frequenza, Boolean consenso){
       
        this.oneTimePassword = oneTimePassword;
        this.otpRequestTime= otpRequestTime;
        this.isEnabled = isEnable;
        this.canale_comunicazione= canaleComunicazione;
        this.frequenza = frequenza;
        this.consenso = consenso;
    }



    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    

    public DettagliTecnici(String oneTimePassword, Date otpRequestTime) {
        this.oneTimePassword = oneTimePassword;
        this.otpRequestTime = otpRequestTime;
    }


    public String getOneTimePassword() {
        return oneTimePassword;
    }


    public void setOneTimePassword(String oneTimePassword) {
        this.oneTimePassword = oneTimePassword;
    }


    public Date getOtpRequestTime() {
        return otpRequestTime;
    }


    public void setOtpRequestTime(Date otpRequestTime) {
        this.otpRequestTime = otpRequestTime;
    }


    public boolean isEnabled() {
        return isEnabled;
    }


    public void setEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }


    public String getCanale_comunicazione() {
        return canale_comunicazione;
    }


    public void setCanale_comunicazione(String canale_comunicazione) {
        this.canale_comunicazione = canale_comunicazione;
    }


    public String getFrequenza() {
        return frequenza;
    }


    public void setFrequenza(String frequenza) {
        this.frequenza = frequenza;
    }


    public boolean isConsenso() {
        return consenso;
    }


    public void setConsenso(boolean consenso) {
        this.consenso = consenso;
    }


   
}



