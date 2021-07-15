package com.cantico.profile.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cantico.profile.dto.UserInfoProfileCustomFilter;
import com.cantico.profile.model.UserInfoProfile;
import com.cantico.profile.repository.UserInfoProfileCustomRepository;

@Service
public class UserInfoProfileCustomRepositoryImpl implements UserInfoProfileCustomRepository{
	
	@Autowired
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserInfoProfile> findClusterProfileByAdmin(UserInfoProfileCustomFilter userInfoProfileCustomFilter) {


		 StringBuilder queryString = new StringBuilder();
	      ArrayList<Object> parametri = new ArrayList<>();
	      queryString.append("select uip.* from public.user_info_profile uip INNER JOIN public.notification n on n.id_user_info_profile = uip.id_user_info_profile where 1=1 ");
	      if (userInfoProfileCustomFilter.getFromAge() != null) {
	         queryString.append(" and uip.age >= ? and uip.age <= ? ");
	         parametri.add(userInfoProfileCustomFilter.getFromAge());
	         parametri.add(userInfoProfileCustomFilter.getToAge());
	      }
	      
	      if(userInfoProfileCustomFilter.getGender() != null) {
	    	  if(!userInfoProfileCustomFilter.getGender().isEmpty()) {
	    		  queryString.append(" and uip.gender IN ( ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getGender().size()-1; indice++)
		 	            queryString.append("'"+userInfoProfileCustomFilter.getGender().get(indice)+"',");
		 	         	queryString.append("'"+userInfoProfileCustomFilter.getGender().get(userInfoProfileCustomFilter.getGender().size()-1)+"'");
		 	         	queryString.append(") ");
	    	  }
	    	 
	      }
	      
	      if(userInfoProfileCustomFilter.getMaritalStatus() != null) {
	    	  if(!userInfoProfileCustomFilter.getMaritalStatus().isEmpty()) {
	    		  queryString.append(" and uip.marital_status IN ( ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getMaritalStatus().size()-1; indice++)
		 	            queryString.append("'"+userInfoProfileCustomFilter.getMaritalStatus().get(indice)+"',");
		 	         	queryString.append("'"+userInfoProfileCustomFilter.getMaritalStatus().get(userInfoProfileCustomFilter.getMaritalStatus().size()-1)+"'");
		 	         	queryString.append(") ");
	    	  }
	    	 
	      }

	      if(userInfoProfileCustomFilter.getEducation() != null) {
	    	  if(!userInfoProfileCustomFilter.getEducation().isEmpty()) {
	    		  queryString.append(" and uip.education IN ( ");
	 	          for(int indice=0; indice < userInfoProfileCustomFilter.getEducation().size()-1; indice++)
	 	        	  	queryString.append("'"+userInfoProfileCustomFilter.getEducation().get(indice)+"',");
	 	          		queryString.append("'"+userInfoProfileCustomFilter.getEducation().get(userInfoProfileCustomFilter.getEducation().size()-1)+"'");
	 	          		queryString.append(") ");
	    	  }
	    	  
	      }
	      
	      if (userInfoProfileCustomFilter.getGeoLocation() != null) {
		         queryString.append(" and uip.geo_location = ? ");
		         parametri.add(userInfoProfileCustomFilter.getGeoLocation());
		      }
	      
	      if(userInfoProfileCustomFilter.getEmployment() != null) {
	    	  if(!userInfoProfileCustomFilter.getEmployment().isEmpty()) {
	    		  queryString.append(" and uip.employment IN ( ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getEmployment().size()-1; indice++)
			 	         queryString.append("'"+userInfoProfileCustomFilter.getEmployment().get(indice)+"',");
			 	         queryString.append("'"+userInfoProfileCustomFilter.getEmployment().get(userInfoProfileCustomFilter.getEmployment().size()-1)+"'");
			 		     queryString.append(") ");
	    	  }
	      }
	      
	      if (userInfoProfileCustomFilter.getDeviceUse() != null) {
		         queryString.append(" and uip.device_use = ? ");
		         parametri.add(userInfoProfileCustomFilter.getDeviceUse());
		      }
	      
	      if(userInfoProfileCustomFilter.getReasonDeviceUse() != null) {
	    	  if(!userInfoProfileCustomFilter.getReasonDeviceUse().isEmpty()) {
	    		  queryString.append(" and uip.reason_device_use IN ( ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getReasonDeviceUse().size()-1; indice++)
			 	         queryString.append("'"+userInfoProfileCustomFilter.getReasonDeviceUse().get(indice)+"',");
			 	         queryString.append("'"+userInfoProfileCustomFilter.getReasonDeviceUse().get(userInfoProfileCustomFilter.getReasonDeviceUse().size()-1)+"'");
			 		     queryString.append(") ");
	    	  }

	      }
	      
	      if(userInfoProfileCustomFilter.getEventFrequency() != null) {
	    	  if(!userInfoProfileCustomFilter.getEventFrequency().isEmpty()) {
	    		  queryString.append(" and uip.event_frequency IN ( ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getEventFrequency().size()-1; indice++)
		 	            queryString.append("'"+userInfoProfileCustomFilter.getEventFrequency().get(indice)+"',");
		 	         	queryString.append("'"+userInfoProfileCustomFilter.getEventFrequency().get(userInfoProfileCustomFilter.getEventFrequency().size()-1)+"'");
		 	         	queryString.append(") ");
	    	  }
	      }

	      if (userInfoProfileCustomFilter.getViewer() != null) {
		         queryString.append(" and uip.viewer = ? ");
		         parametri.add(userInfoProfileCustomFilter.getViewer());
		      }
	      
	      if (userInfoProfileCustomFilter.getCommunityAttendance() != null) {
		         queryString.append(" and uip.community_attendance = ? ");
		         parametri.add(userInfoProfileCustomFilter.getCommunityAttendance());
		      }
	      
	      if(userInfoProfileCustomFilter.getCulturalInteresting() != null) {
	    	  if(!userInfoProfileCustomFilter.getCulturalInteresting().isEmpty()) {
	    		  queryString.append(" and (uip.cultural_interesting LIKE ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getCulturalInteresting().size()-1; indice++)
		 	            queryString.append("'%"+userInfoProfileCustomFilter.getCulturalInteresting().get(indice)+"%' OR uip.cultural_interesting LIKE ");
		 	         	queryString.append("'%"+userInfoProfileCustomFilter.getCulturalInteresting().get(userInfoProfileCustomFilter.getCulturalInteresting().size()-1)+"%'");
		 	         	queryString.append(") ");
	    	  }
	      }
	      
	      if(userInfoProfileCustomFilter.getHobbies() != null) {
	    	  if(!userInfoProfileCustomFilter.getHobbies().isEmpty()) {
	    		  queryString.append(" and (uip.hobby LIKE ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getHobbies().size()-1; indice++)
		 	            queryString.append("'%"+userInfoProfileCustomFilter.getHobbies().get(indice)+"%' OR uip.hobby LIKE ");
		 	         	queryString.append("'%"+userInfoProfileCustomFilter.getHobbies().get(userInfoProfileCustomFilter.getHobbies().size()-1)+"%'");
		 	         	queryString.append(") ");
	    	  }
	      }
	      
	      if(userInfoProfileCustomFilter.getLanguages() != null) {
	    	  if(!userInfoProfileCustomFilter.getLanguages().isEmpty()) {
	    		  queryString.append(" and (uip.languages LIKE ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getLanguages().size()-1; indice++)
		 	            queryString.append("'%"+userInfoProfileCustomFilter.getLanguages().get(indice)+"%' OR uip.languages LIKE ");
		 	         	queryString.append("'%"+userInfoProfileCustomFilter.getLanguages().get(userInfoProfileCustomFilter.getLanguages().size()-1)+"%'");
		 	         	queryString.append(") ");
	    	  }
	      }
	      
	      if(userInfoProfileCustomFilter.getOperaType() != null) {
	    	  if(!userInfoProfileCustomFilter.getOperaType().isEmpty()) {
	    		  queryString.append(" and (uip.opera_type LIKE ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getOperaType().size()-1; indice++)
		 	            queryString.append("'%"+userInfoProfileCustomFilter.getOperaType().get(indice)+"%' OR uip.opera_type LIKE ");
		 	         	queryString.append("'%"+userInfoProfileCustomFilter.getOperaType().get(userInfoProfileCustomFilter.getOperaType().size()-1)+"%'");
		 	         	queryString.append(") ");
	    	  }
	      }
	      
	      if(userInfoProfileCustomFilter.getPurchasingOperaItems() != null) {
	    	  if(!userInfoProfileCustomFilter.getPurchasingOperaItems().isEmpty()) {
	    		  queryString.append(" and (uip.purchasing_opera_items LIKE ");
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getPurchasingOperaItems().size()-1; indice++)
		 	            queryString.append("'%"+userInfoProfileCustomFilter.getPurchasingOperaItems().get(indice)+"%' OR uip.purchasing_opera_items LIKE ");
		 	         	queryString.append("'%"+userInfoProfileCustomFilter.getPurchasingOperaItems().get(userInfoProfileCustomFilter.getPurchasingOperaItems().size()-1)+"%'");
		 	         	queryString.append(") ");
	    	  }
	      }
	      
	      if(userInfoProfileCustomFilter.getNotifications() != null) {
	    	  if(!userInfoProfileCustomFilter.getNotifications().isEmpty()) {
	    		  queryString.append(" and n.id_notification_type in \r\n (select n2.id_notification_type from public.notification n2 where n2.id_user_info_profile = uip.id_user_info_profile and lower(n2.description) IN ( " );
	 	         for(int indice=0; indice < userInfoProfileCustomFilter.getNotifications().size()-1; indice++)
		 	            queryString.append("'"+userInfoProfileCustomFilter.getNotifications().get(indice)+"', ");
		 	         	queryString.append("'"+userInfoProfileCustomFilter.getNotifications().get(userInfoProfileCustomFilter.getNotifications().size()-1)+"'");
		 	         	queryString.append(") and n.enabled = true ");
		 	         	queryString.append(" group by n2.id_notification_type, n2.id_user_info_profile )");  
	    	  }
	      }
	     
	      queryString.append(" group by uip.id_user_info_profile ");
	      queryString.append(" ORDER BY uip.id_user_info_profile");
	      Query query = em.createNativeQuery(queryString.toString(), UserInfoProfile.class);
	      
	      int index = 1;
	      for (Object parametro : parametri) {
	         query.setParameter(index, parametro);
	         index++;
	      }
	      
		List<UserInfoProfile> resultList = query.getResultList();		
		
		return resultList;
	}

}
