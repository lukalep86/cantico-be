package com.cantico.profile.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.cantico.profile.exception.InvalidTokenException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JwtExtractEmail {
	
	public String getPropertyFromToken(String jwt, String property) {
		String email = null;
		
		try{
				//recupera jwt token e accessToken
				JSONObject json = new JSONObject(jwt);
				String token = json.getString("token");    
				//String accessToken = json.getString("accessToken");
				String[] parts = token.split("\\.");
				String header = parts[0];
				String playload = parts[1];
				String signature = parts[2];
													
				Base64 base64Url = new Base64(true);
				ObjectMapper mapper = new ObjectMapper();
				JsonNode node = null;
				String playloadedDecoded = new String(base64Url.decode(playload)); 
							
					// JsonNode jsonNode = mapper.readTree(playloadedDecoded);
					//List<String> list = jsonNode.findValuesAsText("email");
					// JsonNode aField = innerNode.get("customerSessionId");
					node = mapper.readTree(playloadedDecoded);
					email = node.path("email").textValue();
					//email = node.get("email").textValue();
					if (email != null){
						return email;
					}
					else{
							throw new InvalidTokenException("Token non valido: la property email è null");	
						}
					
				}
				catch (JSONException  e) {
					throw new InvalidTokenException("Json non valido");
				  } 
				catch (Exception e) {
					throw new InvalidTokenException("Token non valido");
				  }
		
		
	}

}
