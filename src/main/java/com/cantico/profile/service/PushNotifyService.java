package com.cantico.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cantico.profile.dto.PushNotifyDTO;

@Service
public interface PushNotifyService {
	
	public List<PushNotifyDTO> getPushNotifyByUserInfoProfile(Long idUserInfoProfile);
	
	public void deletePushNotfyById(Integer idPushNotify);
	
	public PushNotifyDTO checkPushNotify(Integer idPushNotify);

}
