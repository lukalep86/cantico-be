package com.cantico.profile.service.impl;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cantico.profile.exception.CRUDException;
import com.cantico.profile.exception.ExpiredOTPException;
import com.cantico.profile.exception.FieldNotNullException;
import com.cantico.profile.exception.InvalidOTPException;
import com.cantico.profile.exception.InvalidPSWException;
import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.model.DettagliTecnici;
import com.cantico.profile.repository.AnagraficaRepository;
import com.cantico.profile.service.AnagraficaService;



@Service
public class AnagraficaServiceImpl implements AnagraficaService {



    Logger logger = LoggerFactory.getLogger(AnagraficaServiceImpl.class);

    private static final String SECRET_KEY = null;

    @Autowired 
    AnagraficaRepository repository;


    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
   


    public AnagraficaServiceImpl(AnagraficaRepository repo){
        this.repository= repo;
     
    }

    @Override
    public List<Anagrafica> findAll() {
        logger.warn("[ANAGRAFICA SERVICE / FINDALL]");
        List<Anagrafica> list = repository.findAll();
        if(list.size() >0)  return list;
        else throw new EntityNotFoundException("Nessun registro esistente");
         
    }

      
    //checkOTP
    @Override
    public Boolean checkOTP(String email, String OTP) {
        logger.warn("[ANAGRAFICA SERVICE / CHECKOTP] OTP inserito " + OTP + "for " + email);
        Boolean  isOTPMatches = false;
        Anagrafica result = repository.findByEmail(email);
        String hashedOTP = result.getDetails().getOneTimePassword();
        if(!(hashedOTP.isEmpty()) || !(hashedOTP.trim().isEmpty())){ 
           isOTPMatches = checkPassword(OTP, hashedOTP);
           logger.warn("[ANAGRAFICA SERVICE / CHECKOTP] isOTPMatches " + isOTPMatches);
           
        }
          if(!isOTPMatches) throw new InvalidOTPException("The OTP inserito non è corretto");
        return isOTPMatches;
  
    }

    @Override
    public boolean isOTPExpires(Anagrafica a, long duration) {
        logger.warn("[ANAGRAFICA SERVICE / ISOTPEXPIRES] ");
        if (a.getDetails().getOtpRequestTime() == null) {
            throw new ExpiredOTPException("OTP tempo di richietsa è null");
        }
         
        long currentTimeInMillis = System.currentTimeMillis();
        long otpRequestedTimeInMillis =a.getDetails().getOtpRequestTime().getTime();
         
        if (otpRequestedTimeInMillis + duration < currentTimeInMillis) {
            logger.warn("[ANAGRAFICA SERVICE / ISOTPEXPIRES] OTP scaduto");
            throw new ExpiredOTPException("codice OTP scaduto");
            
        }
         
        return true;
    }  

      @Override
    public Anagrafica save(Anagrafica anagrafica){
        
        String email = anagrafica.getEmail();      
        logger.warn("[ANAGRAFICA SERVICE / SAVE]  "+ email);
  
        String psw = anagrafica.getPassword()== null ? "" : anagrafica.getPassword();
        if( !(psw.isEmpty()) || !(psw.trim().isEmpty())){
            String encodedPsw = passwordEncoder.encode(anagrafica.getPassword());
           anagrafica.setPassword(encodedPsw);
           
        }else{
            anagrafica.setPassword(psw);
        }
        String nome = anagrafica.getNome() == null ? "" : anagrafica.getNome();
        String cognome = anagrafica.getCognome() == null ? "" : anagrafica.getCognome();
        String sesso = anagrafica.getSesso() == null ? "" : anagrafica.getSesso();
        String codiceFiscale = anagrafica.getCodiceFiscale() == null ? "" : anagrafica.getCodiceFiscale();
        String indirizzo = anagrafica.getIndirizzo()  == null ? "" : anagrafica.getIndirizzo();
        String cap = anagrafica.getCap() == null ? "" : anagrafica.getCap();
        String stato = anagrafica.getStato()  == null ? "" : anagrafica.getStato();
        String provincia = anagrafica.getProvincia() == null ? "" : anagrafica.getProvincia();
        String comune = anagrafica.getComune()  == null ? "" : anagrafica.getComune();
        String cellulare = anagrafica.getCellulare()  == null ? "" : anagrafica.getCellulare();
        DettagliTecnici details = anagrafica.getDetails() == null  ? new DettagliTecnici() : anagrafica.getDetails();
       
        anagrafica.setNome(nome);
        anagrafica.setCognome(cognome);
        anagrafica.setSesso(sesso);
        anagrafica.setCodiceFiscale(codiceFiscale);
        anagrafica.setIndirizzo(indirizzo);
        anagrafica.setCap(cap);
        anagrafica.setStato(stato);
        anagrafica.setProvincia(provincia);
        anagrafica.setComune(comune);
        anagrafica.setCellulare(cellulare);
       
 
       if(details != null){
       
        String OTP = details.getOneTimePassword() == null ? "" : details.getOneTimePassword();
        if(!(OTP.isEmpty()) || !(OTP.trim().isEmpty())){          
                String encodedOTP = passwordEncoder.encode(OTP);
                details.setOneTimePassword(encodedOTP);
            // anagrafica.setDetails(details);
            }
            //
            Date OTPTime = details.getOtpRequestTime() == null ? null : details.getOtpRequestTime();
            details.setOtpRequestTime(OTPTime);
            boolean isConsenso = false;
            String canale_comunicazione = "";
            String frequenza = "";
            if(details.isConsenso()){
                //se consenso è true allora canale_comunicazione e frequenza devono essere valorizzate
                    if(details.getCanale_comunicazione() == null)
                        throw new  FieldNotNullException("Il campo [Canale_comunicazione] fornito è obbligatorio e non deve essere nullo");
                
                    if(details.getFrequenza() == null)
                        throw new FieldNotNullException("Il campo [Frequenza] fornito è obbligatorio e non deve essere nullo");
            }else{

                details.setConsenso(isConsenso);
                details.setCanale_comunicazione(canale_comunicazione);
                details.setFrequenza(frequenza);
                
            }
        }
        anagrafica.setDetails(details);
        try {
            Anagrafica anagraficaNew = repository.save(anagrafica);
            logger.warn("[ANAGRAFICA SERVICE / SAVE]" + anagraficaNew);
            return   anagraficaNew;
            
        } catch (Exception  e) {
            logger.error("[SAVE EXCEPTION] "+ e.getMessage());
            throw new CRUDException(500, "Richiesta di Salvataggio non riuscita", e);
        }
       
    }
    

   

    @Override
    public boolean existsByEmail(String email) {
        logger.warn("[ANAGRAFICA SERVICE / EXISTSBYEMAIL] email "+ email);
             return  repository.existsByEmail(email);
    }

    @Override
    public Boolean update(Long id, Anagrafica anagrafica) {
        logger.warn("[ANAGRAFICA SERVICE / UPDATE] aggiorna Anagrafica con id " + id);
        Optional<Anagrafica> anagraficaToUpdate = null;
        anagraficaToUpdate = repository.findById(id);
        
        if (anagraficaToUpdate.isPresent()) {
			Anagrafica anagraficaExisting = anagraficaToUpdate.get();
            anagraficaExisting.setNome(anagrafica.getNome());
			anagraficaExisting.setCognome(anagrafica.getCognome());           
            anagraficaExisting.setSesso(anagrafica.getSesso());
			anagraficaExisting.setCodiceFiscale(anagrafica.getCodiceFiscale());
			anagraficaExisting.setIndirizzo(anagrafica.getIndirizzo());
			anagraficaExisting.setCap(anagrafica.getCap());
			anagraficaExisting.setStato(anagrafica.getStato());
			anagraficaExisting.setComune(anagrafica.getComune());
			anagraficaExisting.setProvincia(anagrafica.getProvincia());
			anagraficaExisting.setDetails(anagrafica.getDetails());  
            try {
                repository.save(anagraficaExisting);
            } catch (Exception e) {
                logger.error("[UPDATED EXCEPTION] "+ e.getMessage());
                throw new CRUDException(500, "Richiesta di aggiornamento non riuscita", e);
            }
           
				
        
     }
     return true;
   
        }


        @Override
        public Anagrafica update(String email, Anagrafica anagrafica) {
            logger.warn("[ANAGRAFICA SERVICE / UPDATE] aggiorna Anagrafica con email " + email);
            Anagrafica anagraficaExisting  = repository.findByEmail(email);
            Anagrafica updated;
            //EMAIL identifica l'anagrafica quindi non si deve modificare
            if (anagraficaExisting !=null) {

                anagraficaExisting.setNome(anagrafica.getNome());
                anagraficaExisting.setCognome(anagrafica.getCognome());           
                anagraficaExisting.setSesso(anagrafica.getSesso());
                anagraficaExisting.setCodiceFiscale(anagrafica.getCodiceFiscale());
                anagraficaExisting.setIndirizzo(anagrafica.getIndirizzo());
                anagraficaExisting.setCap(anagrafica.getCap());
                anagraficaExisting.setStato(anagrafica.getStato());
                anagraficaExisting.setComune(anagrafica.getComune());
                anagraficaExisting.setProvincia(anagrafica.getProvincia());
                anagraficaExisting.setCellulare(anagrafica.getCellulare());
                //DEI DETTAGLI si possono cambiare solo  "canale_comunicazione",  "frequenza", "consenso"
                DettagliTecnici detailsExisting = anagrafica.getDetails();
                detailsExisting.setCanale_comunicazione(anagrafica.getDetails().getCanale_comunicazione());
                detailsExisting.setFrequenza(anagrafica.getDetails().getFrequenza());
                detailsExisting.setConsenso(anagrafica.getDetails().isConsenso());
                anagraficaExisting.setDetails(detailsExisting); 
                try {
                    updated = repository.save(anagraficaExisting);        
                } catch (Exception e) {
                    logger.error("[UPDATED EXCEPTION] "+ e.getMessage());
                    throw new CRUDException(500, "Anagrafica non aggiornata", e);
                }
                      
            
               }else throw new EntityNotFoundException("Aggiornamento Anagrafica non riuscito: Mail errata o inesistente");
          return  updated;
       
        }


        @Override
        public Anagrafica findById(Long id) {
            logger.warn("[ANAGRAFICA SERVICE / FINDBYID] seleziona Anagrafica con id " + id);
            Optional<Anagrafica> anagrafica = repository.findById(id);	
            return anagrafica.get();
        }

        @Override
        public Anagrafica findByEmail(String email) {
            logger.warn("[ANAGRAFICA SERVICE / FINDBYEMAIL] seleziona Anagrafica con email " + email);
            Anagrafica a = repository.findByEmail(email);
            if(a!=null) 
                return a;
            else throw new EntityNotFoundException("Mail errata o inesistente");
        }

        @Override
        public Boolean deleteByEmail(String email) {
            logger.warn("[ANAGRAFICA SERVICE / DELETEBYEMAIL] cancella Anagrafica con email " + email);
            Anagrafica a = repository.findByEmail(email);
            if(a != null) 
                    repository.deleteByEmail(email);
            else throw new EntityNotFoundException("Mail errata o inesistente");
            return null;
                  
        }

        @Override
        public Boolean delete(long id) {
            logger.warn("[ANAGRAFICA SERVICE / DELETEBYID]  "+ id);
             Optional<Anagrafica> a = repository.findById(id);
            if(a.isPresent()) 
                    repository.deleteById(id);
            else throw new EntityNotFoundException("Id errato o inesistente");
            return null;
        }
       
        public boolean checkPassword(String password, String hashedPassword){
        logger.warn("[ANAGRAFICA SERVICE / CHECKPASSWORD] verifica che le passwords coincidano");
        return passwordEncoder.matches(password, hashedPassword);

    }

        @Override
        public Boolean checkLoginPassword(String email, String password) {
            logger.warn("[ANAGRAFICA SERVICE / CHECKLOGINPASSWORD] verifica che email e password coincidano"+  password + "for " + email);
            Boolean  isPswMatches = false;
            Anagrafica result = repository.findByEmail(email);
            if(result !=null){
                String hashedPsw = result.getPassword();
                if(!(hashedPsw.isEmpty()) || !(hashedPsw.trim().isEmpty())){
                    isPswMatches =checkPassword(password, hashedPsw);
                    logger.info("[ANAGRAFICA SERVICE / CHECKLOGINPASSWORD] isPswMatches " + isPswMatches);
                }
            }else throw new EntityNotFoundException("Wrong email or doesn't exists");
              if(!isPswMatches) throw new InvalidPSWException("La password inserita non è corretta");
            return isPswMatches;
        } 
       
  

        
     
 
  
 }

    
  
 
    
