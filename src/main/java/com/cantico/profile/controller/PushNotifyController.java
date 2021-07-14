package com.cantico.profile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.dto.PushNotifyDTO;
import com.cantico.profile.service.PushNotifyService;

@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/push")
public class PushNotifyController {
	
	@Autowired
	PushNotifyService pushNotifyService;
	
	@GetMapping("/{idUserInfoProfile}")
	public ResponseEntity<List<PushNotifyDTO>> getPushNotifyByUserInfoProfile(@PathVariable("idUserInfoProfile") Long idUserInfoProfile){
		
		List<PushNotifyDTO> pushNotifyList = pushNotifyService.getPushNotifyByUserInfoProfile(idUserInfoProfile);
		
		return new ResponseEntity<List<PushNotifyDTO>>(pushNotifyList,HttpStatus.OK);
		
	}

	@PutMapping("/checkPush/{idPushNotify}")
	public ResponseEntity<PushNotifyDTO> checkPush(@PathVariable("idPushNotify")Integer idPushNotify){
		
		PushNotifyDTO pushNotify = pushNotifyService.checkPushNotify(idPushNotify);
		
		return new ResponseEntity<PushNotifyDTO>(pushNotify,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{idPushNotify}")
	public ResponseEntity<Void> deletePush(@PathVariable("idPushNotify")Integer idPushNotify){
			
		pushNotifyService.deletePushNotfyById(idPushNotify);
			
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
