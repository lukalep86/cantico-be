package com.cantico.profile.cloud;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cantico.profile.cloud.impl.AnagraficaClientCustom;

import io.swagger.annotations.ApiOperation;

@FeignClient(name = "${canticoIdm.name}", url ="${canticoIdm.url}")
public interface AnagraficaClient {
	
	@GetMapping(value = "/Anagrafica/{email}")
	@ApiOperation(value = "Find registry", notes = "This method findes existing registries")
	@ResponseBody public ResponseEntity<AnagraficaClientCustom> findAnagrafica(@PathVariable("email") @Valid String email);

}
