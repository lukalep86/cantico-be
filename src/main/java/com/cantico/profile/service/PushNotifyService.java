package com.cantico.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cantico.profile.dto.PushNotifyDTO;

@Service
public interface PushNotifyService {
	
	public List<PushNotifyDTO> getPushNotifyByUserInfoProfile(long idUserInfoProfile);
	
	public void deletePushNotfyById(int idPushNotify);
	
	public PushNotifyDTO checkPushNotify(int idPushNotify);

}
