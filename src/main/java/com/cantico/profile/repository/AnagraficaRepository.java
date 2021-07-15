package com.cantico.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cantico.profile.model.Anagrafica;

@Repository
public interface AnagraficaRepository extends JpaRepository<Anagrafica, Long>{

}
