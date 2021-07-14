package com.cantico.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cantico.profile.model.Anagrafica;
import com.cantico.profile.model.UserInfoProfile;

@Repository
public interface UserInfoProfileRepository extends JpaRepository<UserInfoProfile, Long>{
	
	UserInfoProfile findByUserAnagrafica(Anagrafica userAnagrafica);
	
	@Query(value = "select a.* from Anagrafica where a.id = :idAnagrafica", nativeQuery = true)
	UserInfoProfile findByUserAnagraficaWhereId(@Param("idAnagrafica") Long idAnagrafica);
	
}
