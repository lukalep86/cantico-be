package com.cantico.profile.utils;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.profiles")
public class ConfigProperties {
    
    
    private String active;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }


    @Override
	public String toString() {
		return "Profilo attivo in Config [" + getActive() + "]";
	}
}
