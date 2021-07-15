package com.cantico.profile.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.cantico.profile.cloud.AnagraficaClient;
import com.cantico.profile.cloud.impl.AnagraficaClientCustom;
import com.cantico.profile.dto.NotificationDTO;
import com.cantico.profile.dto.SendCustomNotification;
import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.dto.UserInfoProfileDTO;
import com.cantico.profile.dto.mapper.UserInfoProfileMapper;
import com.cantico.profile.exception.MailAuthenticationException;
import com.cantico.profile.exception.ResourceNotFoundException;
import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.model.Notification;
import com.cantico.profile.model.PushNotify;
import com.cantico.profile.model.UserInfoProfile;
import com.cantico.profile.repository.AnagraficaRepository;
import com.cantico.profile.repository.NotificationRepository;
import com.cantico.profile.repository.PushNotifyRepository;
import com.cantico.profile.repository.UserInfoProfileRepository;
import com.cantico.profile.repository.impl.UserInfoProfileCustomRepositoryImpl;
import com.cantico.profile.service.UserInfoProfileService;

@Component
public class UserInfoProfileServiceImpl implements UserInfoProfileService{
	
	Logger logger = LoggerFactory.getLogger(UserInfoProfileServiceImpl.class);
	
	@Autowired
	UserInfoProfileRepository userInfoProfileRepository;
	
	@Autowired
	UserInfoProfileCustomRepositoryImpl userInfoProfileCustomRepositoryImpl;
	
	@Autowired
	NotificationRepository notificationRepository;
	
	@Autowired
	AnagraficaRepository anagraficaRepository;
	
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	PushNotifyRepository pushNotifyRepository;
	
	@Autowired
	AnagraficaClient anagraficaClient;

	@Override
	@Transactional
	public UserInfoProfileDTO createUpdateUserInfoProfile(UserInfoProfileDTO userInfoProfileDTO, Long idAnagrafica) {
		
		UserInfoProfileDTO userInfoProfileDTOResponse = new UserInfoProfileDTO();
		
		Set<Notification> notificationList = new HashSet<>();
				
		Optional<Anagrafica> anagrafica = anagraficaRepository.findById(idAnagrafica);
		if(!anagrafica.isPresent()) {
			throw new ResourceNotFoundException("No User Found with id: " + idAnagrafica);
		}
		
		if(userInfoProfileDTO.getIdUserInfoProfile() != null) {
			Optional<UserInfoProfile> userInfoProfileDb = userInfoProfileRepository.findById(userInfoProfileDTO.getIdUserInfoProfile());
			if(userInfoProfileDb.isPresent()) {
				UserInfoProfile userInfoProfileStored = userInfoProfileDb.get();
				userInfoProfileStored.setDateModify(new Date());
				UserInfoProfile userProfileUpdate = UserInfoProfileMapper.updateUserInfoProfileDTO(userInfoProfileStored, userInfoProfileDTO);
				if(!userInfoProfileDTO.getNotifications().isEmpty()) {
					for(NotificationDTO notification : userInfoProfileDTO.getNotifications()) {
						if(notification.getIdNotificationType() == null) {
							Notification notificationCreate = new Notification();
							notificationCreate.setUserInfoProfile(userInfoProfileStored);
							notificationCreate.setDescription(notification.getDescription());
							notificationCreate.setEnabled(notification.getEnabled());
							notificationList.add(notificationCreate);
						}else {
							Optional<Notification> notificationUpdateOpt = notificationRepository.findById(notification.getIdNotificationType());
							if(notificationUpdateOpt.isPresent()) {
								Notification notificationUpdate = notificationUpdateOpt.get();
								notificationUpdate.setEnabled(notification.getEnabled());
								notificationList.add(notificationUpdate);
							}
						}
					}
					notificationRepository.saveAll(notificationList);
				}
				userInfoProfileRepository.save(userProfileUpdate);
				
				userProfileUpdate.setNotification(notificationList);
				userInfoProfileDTOResponse= UserInfoProfileMapper.toUserInfoProfileDTO(userProfileUpdate);
				
			}else {
				throw new ResourceNotFoundException("No User Profile found with id: " + userInfoProfileDTO.getIdUserInfoProfile());
			}
		}else {
			UserInfoProfile newUserInfoProfile = UserInfoProfileMapper.toUserInfoProfile(userInfoProfileDTO);
			newUserInfoProfile.setDateInsert(new Date());
			newUserInfoProfile.setUserAnagrafica(anagrafica.get());
			userInfoProfileRepository.save(newUserInfoProfile);
			
			if(userInfoProfileDTO.getNotifications() != null || !userInfoProfileDTO.getNotifications().isEmpty()) {
				for(NotificationDTO notification : userInfoProfileDTO.getNotifications()) {
					Notification notificationCreate = new Notification();
					notificationCreate.setDescription(notification.getDescription());
					notificationCreate.setUserInfoProfile(newUserInfoProfile);
					notificationCreate.setEnabled(notification.getEnabled());
					notificationList.add(notificationCreate);
				}
				notificationRepository.saveAll(notificationList);
			}
			
			newUserInfoProfile.setNotification(notificationList);
			userInfoProfileDTOResponse= UserInfoProfileMapper.toUserInfoProfileDTO(newUserInfoProfile);

		}
		return userInfoProfileDTOResponse;
	}

	@Override
	public List<UserInfoProfileDTO> getUserInfoProfileList() {
		
		List<UserInfoProfile> userInfoProfileList = userInfoProfileRepository.findAll();
		List<UserInfoProfileDTO> userInfoProfileDTOList = new ArrayList<>();
		for(UserInfoProfile userInfoProfile : userInfoProfileList) {
			UserInfoProfileDTO userInfoProfileDTO = UserInfoProfileMapper.toUserInfoProfileDTO(userInfoProfile);
			userInfoProfileDTOList.add(userInfoProfileDTO);
		} 
		
		return userInfoProfileDTOList;
	}

	@Override
	public UserInfoProfileDTO getUserInfoProfileByUserAnagrafica(AnagraficaClientCustom anagraficaClient) {
		
		UserInfoProfile userInfoProfile = userInfoProfileRepository.getUserInfoProfileByUserIdAnagrafica(anagraficaClient.getId());
		UserInfoProfileDTO userInfoProfileDTO = new UserInfoProfileDTO();
		
		if(userInfoProfile != null) {
			userInfoProfileDTO = UserInfoProfileMapper.toUserInfoProfileDTO(userInfoProfile);
			userInfoProfileDTO.setEmail(anagraficaClient.getEmail());
			
		}
		
		return userInfoProfileDTO;
	}

	@Override
	public List<UserInfoProfileDTO> getUserFilterByAdmin(UserInfoProfileCustomFilter userInfoProfileCustomFilter) {
		
		List<UserInfoProfile> userProfileClusterList = userInfoProfileCustomRepositoryImpl.findClusterProfileByAdmin(userInfoProfileCustomFilter);
		List<UserInfoProfileDTO> userProfileClusterListDTO = new ArrayList<>();
		if(!userProfileClusterList.isEmpty()) {
			for(UserInfoProfile userProfileCluster : userProfileClusterList) {
				UserInfoProfileDTO userInfoProfileClusterDTO = UserInfoProfileMapper.toUserInfoProfileDTO(userProfileCluster);
				userProfileClusterListDTO.add(userInfoProfileClusterDTO);
			}
		}		
		return userProfileClusterListDTO;
	}

	@Override
	@Transactional
	public SendCustomNotification sendNotification(SendCustomNotification sendCustomNotification) throws MailAuthenticationException, ParseException {
		
		Logger logger = LoggerFactory.getLogger(UserInfoProfileServiceImpl.class);
		
		for(Long idUser : sendCustomNotification.getMailTo()) {
			Optional<Anagrafica> anagrafica = anagraficaRepository.findById(idUser);
			if(anagrafica.isPresent()) {
				Anagrafica user = anagrafica.get();
				String email = user.getEmail();
				String telephone = user.getCellulare();
				UserInfoProfile userInfoProfile = userInfoProfileRepository.findByUserAnagrafica(user);
				//if(userInfoProfile.getNotificationRecieved() == null || userInfoProfile.getNotificationRecieved() == false) {
					List<Notification> notificationList = notificationRepository.findByUserInfoProfile(userInfoProfile);
					if(!notificationList.isEmpty()) {
						for(Notification notification : notificationList) {
							if(notification.getDescription().equalsIgnoreCase("EMAIL") && notification.getEnabled() == true) {
								 MimeMessage message = mailSender.createMimeMessage();              
									MimeMessageHelper helper = new MimeMessageHelper(message);
									try{		
											helper.setFrom("canticoidm@gmail.com", "CANTICO");
											helper.setTo(email);
											
											String subject = "Notifica Invito Evento";
															
											helper.setSubject(subject);
											
											helper.setText(sendCustomNotification.getContent(), true);
											
											mailSender.send(message);
									} catch (MessagingException e) {
									
										logger.debug("SENDTOEMAIL Errore durante la connessione all'account e-mail ", e.getCause());
										throw new MailAuthenticationException("Tentativo di connessione al server Gmail come provider SMTP: il tentativo di accesso è stato impedito");
							            
							        } 
									catch (Exception e) {
										logger.debug("SENDTOEMAIL Errore durante la connessione all'account e-mail  ", e.getCause());
										throw new MailAuthenticationException("Tentativo di connessione al server Gmail come provider SMTP: il tentativo di accesso è stato impedito");
							        }
									
									sendCustomNotification.setEmail(true);
							}
							if(notification.getDescription().equalsIgnoreCase("SMS") && notification.getEnabled() == true) {
								// implements sms notify
								sendCustomNotification.setSms(true);
							}
							if(notification.getDescription().equalsIgnoreCase("PUSH") && notification.getEnabled() == true) {
								
								PushNotify pushNotify = new PushNotify();
								pushNotify.setUserInfoProfile(userInfoProfile);
								pushNotify.setContent(sendCustomNotification.getContent());
								pushNotify.setChecked(false);
								pushNotify.setDateInsert(new Date());
								pushNotifyRepository.save(pushNotify);
								
								sendCustomNotification.setPush(true);
							}
							
							userInfoProfile.setNotificationRecieved(true);
							userInfoProfile.setDateNotificationRecieved(new Date());
							/*String date = sendCustomNotification.getEventDate().plusDays(10).toString();
							Date toDate = new SimpleDateFormat("yyyy/MM/dd").parse(date);
							userInfoProfile.setDateNotificationExperied(toDate);*/
							userInfoProfileRepository.save(userInfoProfile);
						}
					}
				//}
			}
		}
		
		return sendCustomNotification;
	}

}
