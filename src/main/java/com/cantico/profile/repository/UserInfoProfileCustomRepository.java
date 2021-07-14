package com.cantico.profile.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.model.UserInfoProfile;

@Repository
public interface UserInfoProfileCustomRepository {
	
	List<UserInfoProfile> findClusterProfileByAdmin(@Param("userInfoProfileCustomFilter") UserInfoProfileCustomFilter userInfoProfileCustomFilter);

}
