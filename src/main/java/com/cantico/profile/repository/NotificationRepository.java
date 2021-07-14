package com.cantico.profile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantico.profile.model.Notification;
import com.cantico.profile.model.UserInfoProfile;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{
	
	List<Notification> findByUserInfoProfile(UserInfoProfile userInfoProfile);

}
