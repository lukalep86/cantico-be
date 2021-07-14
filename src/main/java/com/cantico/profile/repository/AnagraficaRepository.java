package com.cantico.profile.repository;




import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cantico.profile.model.Anagrafica;


@Repository
public interface AnagraficaRepository extends JpaRepository<Anagrafica, Long> {

  @Query("SELECT CASE WHEN count(a) > 0 THEN true ELSE false END FROM Anagrafica a where a.email = ?1")
  Boolean existsByEmail(String email);

  @Query("SELECT a FROM Anagrafica a WHERE a.email =:email")
  Anagrafica findByEmail(String email);

  @Transactional
  @Modifying
  @Query("DELETE from Anagrafica a where a.email=:email")
  void deleteByEmail(@Param("email") String email);
  



  }
