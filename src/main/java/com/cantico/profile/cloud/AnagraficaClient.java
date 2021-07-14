package com.cantico.profile.cloud;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cantico.profile.cloud.impl.AnagraficaClientCustom;

import io.swagger.annotations.ApiOperation;

@FeignClient(name = "canticoIDM", url = "{canticoIdm.url}", decode404 = true)
public interface AnagraficaClient {
	
	@GetMapping(value = "/{email}")
	@ApiOperation(value = "Find registry", notes = "This method findes existing registries")
	public ResponseEntity<AnagraficaClientCustom> findAnagrafica(@PathVariable("email") @Valid String email);


}
