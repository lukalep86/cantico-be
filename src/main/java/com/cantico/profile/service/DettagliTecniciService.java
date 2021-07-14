package com.cantico.profile.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cantico.profile.model.DettagliTecnici;



@Service
public interface DettagliTecniciService {

   
    
    
    public List<DettagliTecnici> findAll();
    public DettagliTecnici findById(Long id);

    public DettagliTecnici save(DettagliTecnici d);

    public Boolean update(DettagliTecnici d);

    public Boolean delete(long id);
    public Boolean delete(DettagliTecnici a);

   
}
