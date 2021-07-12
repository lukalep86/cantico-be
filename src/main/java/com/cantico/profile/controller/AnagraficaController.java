package com.cantico.profile.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.Enum.ServiceStatus;
import com.cantico.profile.exception.InvalidTokenException;
import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.model.DettagliTecnici;
import com.cantico.profile.service.AnagraficaService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;
import net.bytebuddy.utility.RandomString;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/Anagrafica")
public class AnagraficaController  {

	
	Logger logger = LoggerFactory.getLogger(AnagraficaController.class);

    @Autowired
    AnagraficaService service;

	@Autowired
	JavaMailSender mailSender;
	

   private static final long OTP_VALID_DURATION = 5 * 60 * 1000; // 5 minutes	


	@PostMapping(value = "/", consumes = "application/json", produces = "application/json")
	@ApiOperation(value = "Create registry", notes = "This method creates a new registry")
	public ResponseEntity<ServiceStatus> addAnagrafica(@RequestBody @Valid Anagrafica anagrafica){
		logger.warn("[*POST / ADDANAGRAFICA]");
		 Anagrafica response = service.save(anagrafica);
		 logger.warn("[*POST / ADDANAGRAFICA] Creata nuova Anagrafica con email: "+ anagrafica.getEmail());
		return new ResponseEntity<ServiceStatus>(ServiceStatus.CREATED_SUCCESS, HttpStatus.CREATED);
		
	
	}



	@GetMapping(value = "/")
	@ApiOperation(value = "Find registry", notes = "This method findes existing registries")
	public ResponseEntity<List<Anagrafica>> findAnagrafica(){
		logger.warn("[GET / FINDANAGRAFICA]");	
		List<Anagrafica> list = service.findAll();
		logger.warn("[GET / FINDANAGRAFICA] restituisce tutte le Anagrafiche");	
		return ResponseEntity.ok(list);
	}


	@GetMapping(value = "/{email}")
	@ApiOperation(value = "Find registry", notes = "This method findes registry by email")
	public ResponseEntity<Anagrafica> findAnagrafica(@PathVariable("email") @Valid String email){
		logger.warn("[GET / FINDANAGRAFICABYEMAIL] ");	
		Anagrafica result = service.findByEmail(email);
		logger.warn("[GET / FINDANAGRAFICABYEMAIL] restituisce l' Anagrafica con email" + email);	
		return result != null ? ResponseEntity.ok(result) : ResponseEntity.notFound().build();
		


	}


	@PutMapping(value="/{email}",  produces = "application/json")
	@ApiOperation(value = "Update registry", notes = "This method update registry by email")
	public ResponseEntity<ServiceStatus> putAnagrafica(@PathVariable("email") @Valid String email, @RequestBody Anagrafica a) {
		logger.warn("[PUT / PUTANAGRAFIA]");
		Anagrafica response = service.update(email, a);
		logger.warn("[PUT / PUTANAGRAFIA] aggiorna l'Anagrafica con email " + email);
		return new ResponseEntity<ServiceStatus>(ServiceStatus.UPDATED_SUCCESS, HttpStatus.ACCEPTED);
		
	}

	
	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Delete registry", notes = "This method deletes registry by id")
	public ResponseEntity<ServiceStatus> deleteAnagrafica(@PathVariable Long id){
		logger.warn("[DELETE / DELETEANAGRAFIA]");
		Boolean result = service.delete(id);
		logger.warn("[DELETE / DELETEANAGRAFIA] cancellata l'Anagrafica con ID " + id);
		return new ResponseEntity<ServiceStatus>(ServiceStatus.DELETED_SUCCESS, HttpStatus.ACCEPTED);
	}

	
	@DeleteMapping()
	@ApiOperation(value = "Delete registry", notes = "This method deletes registry by email")
	public ResponseEntity<ServiceStatus> deleteByEmail(@RequestParam(value="email") @Valid String email){
		logger.warn("[DELETE / DELETEANAGRAFIABYEMAIL] ");
		service.deleteByEmail(email);
		logger.warn("[DELETE / DELETEANAGRAFIABYEMAIL] cancellata l'Anagrafica con email " + email);
		return new ResponseEntity<ServiceStatus>(ServiceStatus.DELETED_SUCCESS, HttpStatus.ACCEPTED);
		
	}

	@GetMapping("login/{email}/{password}")
	public ResponseEntity<ServiceStatus> login(@PathVariable("email")  @Valid String email, @PathVariable("password") String password){
		logger.warn("[GET / LOGIN] verifica login dell'Anagrafica con " + email);
		service.checkLoginPassword(email, password);
		return new ResponseEntity<ServiceStatus>(ServiceStatus.LOGIN_SUCCESS, HttpStatus.ACCEPTED);
	}

	@PutMapping("OTP/{email}")
	@ApiOperation(value = "Create OTP", notes = "This method creates a new OTP")
	public ResponseEntity<ServiceStatus> createOTPByEmail(@PathVariable("email") @Valid String email) throws UnsupportedEncodingException, MessagingException {
		logger.warn("[PUT / CREATEOTPBYEMAIL] crea OTP dell'Anagrafica con email " + email);
		Anagrafica a = service.findByEmail(email);
		
		logger.warn("Chiamata a createOTPByEmail ", email);
		Anagrafica anagraficaOTP = new Anagrafica();
		if(service.existsByEmail(email)){
			String OTP = RandomString.make(8);
			logger.warn("OTP "+ OTP + "\n EMAIL "+email);
			long millis=System.currentTimeMillis(); 
			DettagliTecnici details = a.getDetails();
			details.setOneTimePassword(OTP);		
			details.setOtpRequestTime(new java.sql.Date(millis));
			details.setEnabled(false);
			a.setDetails(details);		 
			anagraficaOTP = service.save(a);
			//invia codice generato via email
			sendOTPEmail(a, OTP);
			
		}		
		return new ResponseEntity<ServiceStatus>(ServiceStatus.OTP_CREATED_SUCCESS, HttpStatus.ACCEPTED);
	}
 
	
	public void sendOTPEmail(Anagrafica a, String OTP)throws UnsupportedEncodingException, MessagingException {
		String email = a.getEmail();
		logger.warn("[PUT / CREATEOTPBYEMAIL - sendOTPEmail] invia OTP alla email " + email);
        MimeMessage message = mailSender.createMimeMessage();              
		MimeMessageHelper helper = new MimeMessageHelper(message);
		 
		try{		
				helper.setFrom("canticoidm@gmail.com", "CANTICO");
				helper.setTo(email);
				
				String subject = "Ecco la tua One Time Password (OTP): scade tra 5 minuti!";
								
				String content = "<p>Ciao,</p>"
						+ "<p>Per motivi di sicurezza, ti viene richiesto di utilizzare la seguente "
						+ "password per verificare la tua identità:</p>"
						+ "<p><b>" + OTP + "</b></p>"
						+ "<br>"
						+ "<p>Note: questo codice scadrà tra 5 minuti.</p>";
				
				helper.setSubject(subject);
				
				helper.setText(content, true);
				
				mailSender.send(message);
		} catch (MessagingException e) {
		
			logger.debug("SENDTOEMAIL Errore durante la connessione all'account e-mail ", e.getCause());
			throw new MailAuthenticationException("Tentativo di connessione al server Gmail come provider SMTP: il tentativo di accesso è stato impedito");
            
        } 
		catch (Exception e) {
			logger.debug("SENDTOEMAIL Errore durante la connessione all'account e-mail  ", e.getCause());
			throw new MailAuthenticationException("Tentativo di connessione al server Gmail come provider SMTP: il tentativo di accesso è stato impedito");
        }
		
    } 
	
	 @GetMapping("checkOtp/{email}/{OTP}")
	 @ApiOperation(value = "Check OTP", notes = "This method validates OTP")
	 public ResponseEntity<ServiceStatus> validateOtp(@PathVariable("email") String email, @PathVariable("OTP") String OPTReceived){
		 logger.warn("[GET / VALIDATEOTP] verifica OTP ricevuto via email " + email);
		Anagrafica a = service.findByEmail(email);
		Anagrafica result = new Anagrafica();
		 if(service.checkOTP(email, OPTReceived)){			
   
			if(service.isOTPExpires(a, OTP_VALID_DURATION)){
				//se OTP non è scaduta setto isEnabled a true 
				DettagliTecnici details = a.getDetails();
				details.setEnabled(true);
				a.setDetails(details);
				result = service.save(a);
				
			}			
					
		 }
		 return new ResponseEntity<ServiceStatus>(ServiceStatus.OTP_VALIDATED_SUCCESS, HttpStatus.ACCEPTED);
	
	}
 		
	//estrae dal Token l'email
	//se l'email NON è presente sul db: crea una nuova anagrafica con tutti i campi a null eccetto l'email (playload)
	//se l'email è presente sul db: seleziona l' anagrafica con l'email recuperata dal playload
	//restituisce l'Anagrafica
	@GetMapping("/token/")
	@ApiOperation(value = "Get email", notes = "This method email extracts form JWT token")
	public ResponseEntity<Anagrafica> findEmailfromJWT(
		@RequestHeader(required = true, name = "authorization") String jwt) {
			Anagrafica result= findAndSaveEmailfromJWT(jwt);
			return ResponseEntity.ok(result);

}



	@GetMapping("extractToken/")
	@ApiOperation(value = "Get email", notes = "This method extracts email prpoperty from JWT token")
	public ResponseEntity<Anagrafica> extractToken(@RequestHeader(required = false, value = "Authorization") String  token) {
	
			Anagrafica result= findAndSaveEmailfromJWT(token);
			return ResponseEntity.ok(result);
	}


	public Anagrafica findAndSaveEmailfromJWT(String JWT){
		Anagrafica a = new Anagrafica();

				if(!JWT.isEmpty() || !JWT.trim().isEmpty() || JWT == null ){  

						String email = getPropertyFromToken(JWT, "email");
						
						if(service.existsByEmail(email)){

							a = service.findByEmail(email);
							
						}else{
						
							a.setEmail(email);
							a =  service.save(a);
						}
				}else
				 {	throw new InvalidTokenException("Token è null");			

				}	
		return a;
   		}

					/*
					TOKEN INVIATO DA SSO :
					{
						"token": "HEADER.PLAYLOAD.SIGNATURE",
						"accessToken": "",
						"username": "",
						"roles": []
					}
					*/
	public String getPropertyFromToken(String jwt, String property) {
		String email = null;
		logger.warn("[ANAGRAFICA SERVICE / GETPROPERTYFROMTOKEN ] " + jwt);
		
		try{
				//recupera jwt token e accessToken
				JSONObject json = new JSONObject(jwt);
				String token = json.getString("token");    
				//String accessToken = json.getString("accessToken");
				String[] parts = token.split("\\.");
				String header = parts[0];
				String playload = parts[1];
				String signature = parts[2];
													
				Base64 base64Url = new Base64(true);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = null;
				String playloadedDecoded = new String(base64Url.decode(playload)); 
				
				logger.warn("[ANAGRAFICA SERVICE / GETPROPERTYFROMTOKEN playload ] " + playloadedDecoded);
			
					// JsonNode jsonNode = mapper.readTree(playloadedDecoded);
					//List<String> list = jsonNode.findValuesAsText("email");
					// JsonNode aField = innerNode.get("customerSessionId");
					node = mapper.readTree(playloadedDecoded);
					email = node.path("email").textValue();
					//email = node.get("email").textValue();
					if (email != null){
						logger.warn("[ANAGRAFICA SERVICE / GETPROPERTYFROMTOKEN prop: email ] " + email);
						return email;
					}
					else{
							throw new InvalidTokenException("Token non valido: la property email è null");	
						}
					
				}
				catch (JSONException  e) {
					logger.debug("[ANAGRAFICA SERVICE / GETPROPERTYFROMTOKEN]" +e.getMessage());
					throw new InvalidTokenException("Json non valido");
				  } 
				catch (Exception e) {
					logger.debug("[ANAGRAFICA SERVICE / GETPROPERTYFROMTOKEN]" +e.getMessage());
					throw new InvalidTokenException("Token non valido");
				  }
		
		
	}
	
}




