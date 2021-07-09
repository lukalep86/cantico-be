package com.cantico.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cantico.profile.model.DettagliTecnici;

@Repository
public interface DettagliTecniciRepository extends JpaRepository<DettagliTecnici, Long> {
 
  
 
  }
