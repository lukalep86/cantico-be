package com.cantico.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantico.profile.model.PushNotify;
import com.cantico.profile.model.UserInfoProfile;

public interface PushNotifyRepository extends JpaRepository<PushNotify, Integer>{
	
	List<PushNotify> findByUserInfoProfile(UserInfoProfile userInfoProfile);

}
