package com.cantico.profile.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cantico.profile.dto.PushNotifyDTO;
import com.cantico.profile.model.PushNotify;
import com.cantico.profile.model.UserInfoProfile;
import com.cantico.profile.repository.PushNotifyRepository;
import com.cantico.profile.repository.UserInfoProfileRepository;
import com.cantico.profile.service.PushNotifyService;

@Component
public class PushNotifyServiceImpl implements PushNotifyService{
	
	@Autowired
	PushNotifyRepository pushNotifyRepository;
	
	@Autowired
	UserInfoProfileRepository userInfoProfileRepository;

	@Override
	public List<PushNotifyDTO> getPushNotifyByUserInfoProfile(Long idUserInfoProfile) {
		
		Optional<UserInfoProfile> userInfoProfile = userInfoProfileRepository.findById(idUserInfoProfile);
		List<PushNotifyDTO> pushNotifyDTOList = new ArrayList<>();
		if(userInfoProfile.isPresent()) {
			List<PushNotify> pushNotifyList = pushNotifyRepository.findByUserInfoProfile(userInfoProfile.get());
			if(!pushNotifyList.isEmpty()) {
				for(PushNotify pushNotify : pushNotifyList) {
					PushNotifyDTO pushNotifyDTO = new PushNotifyDTO();
					pushNotifyDTO.setIdPushNotify(pushNotify.getIdPushNotify());
					pushNotifyDTO.setIdUserProfile(pushNotify.getUserInfoProfile().getIdUserInfoProfile());
					pushNotifyDTO.setChecked(pushNotify.getChecked());
					pushNotifyDTO.setContent(pushNotify.getContent());
					pushNotifyDTOList.add(pushNotifyDTO);
				}
			}
		}
		
		return pushNotifyDTOList;
	}

	@Override
	public void deletePushNotfyById(Integer idPushNotify) {
		
		Optional<PushNotify> pushNotify = pushNotifyRepository.findById(idPushNotify);
		if(pushNotify.isPresent()) {
			pushNotifyRepository.delete(pushNotify.get());
		}
	}

	@Override
	public PushNotifyDTO checkPushNotify(Integer idPushNotify) {
		
		Optional<PushNotify> pushNotify = pushNotifyRepository.findById(idPushNotify);
		PushNotifyDTO pushDTO = new PushNotifyDTO();
		if(pushNotify.isPresent()) {
			PushNotify push = pushNotify.get();
			push.setChecked(true);
			push = pushNotifyRepository.save(push);
			
			pushDTO.setIdPushNotify(push.getIdPushNotify());
			pushDTO.setIdUserProfile(push.getUserInfoProfile().getIdUserInfoProfile());
			pushDTO.setChecked(push.getChecked());
			pushDTO.setContent(push.getContent());
			
		}
		
		return pushDTO;
	}

}
