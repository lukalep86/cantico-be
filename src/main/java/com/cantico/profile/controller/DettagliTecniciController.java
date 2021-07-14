package com.cantico.profile.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import com.cantico.profile.model.DettagliTecnici;
import com.cantico.profile.service.DettagliTecniciService;
@CrossOrigin(origins = "*", allowedHeaders="*")
@RestController
@RequestMapping("/api")
public class DettagliTecniciController {

   //protected Logger _logger = LoggerFactory.getLogger(DettagliTecniciController.class);

    @Autowired
   DettagliTecniciService service;    
 
	

   @PostMapping(value = "/AnagraficaDettagli", consumes = "application/json")
   public ResponseEntity<DettagliTecnici> addAnagraficaDettagli(@RequestBody DettagliTecnici details){
	   DettagliTecnici response = service.save(details);
	   return ResponseEntity.ok(response);
   }

   @GetMapping(value = "/AnagraficaDettagli")
   public ResponseEntity<List<DettagliTecnici>> findAnagraficaDettagli(){
	   List<DettagliTecnici> list = service.findAll();
	   return ResponseEntity.ok(list);
   }

   @GetMapping(value = "/AnagraficaDettagli/{id}")
   public ResponseEntity<DettagliTecnici> findAnagraficaDettagli(@PathVariable Long id){
		DettagliTecnici details = service.findById(id);
	   return ResponseEntity.ok(details);
   }
   @PutMapping(value="/AnagraficaDettagli")
   public ResponseEntity<Boolean> putAnagraficaDettagli(@RequestBody DettagliTecnici details) {
	   return ResponseEntity.ok(service.update(details));
   }

   @DeleteMapping(value="/AnagraficaDettagli/{id}")
   public ResponseEntity<Boolean> deleteAnagraficaDettagli(@PathVariable Long id){
	   Boolean result = service.delete(id);
	   return ResponseEntity.ok(result);
   }

	

	
}

