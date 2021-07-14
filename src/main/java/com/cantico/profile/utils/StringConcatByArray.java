package com.cantico.profile.utils;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StringConcatByArray {
	
	public static String concatByArray(List<String> items) {
		
		StringBuilder concat = new StringBuilder();
		
		if(!items.isEmpty()) {
			for(String item : items) {
				concat.append(item)
				.append(", ");
			}
			concat.deleteCharAt(concat.lastIndexOf(", "));
		}
		
		return concat.toString();
	}

}
