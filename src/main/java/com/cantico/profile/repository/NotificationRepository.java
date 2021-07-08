package com.cantico.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cantico.profile.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Integer>{

}
