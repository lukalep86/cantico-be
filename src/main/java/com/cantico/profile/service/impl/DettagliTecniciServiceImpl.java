package com.cantico.profile.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cantico.profile.model.DettagliTecnici;
import com.cantico.profile.repository.DettagliTecniciRepository;
import com.cantico.profile.service.DettagliTecniciService;



@Service
public class DettagliTecniciServiceImpl implements DettagliTecniciService{

    @Autowired
    DettagliTecniciRepository repository;

   PasswordEncoder passwordEncoder;


    public DettagliTecniciServiceImpl(DettagliTecniciRepository repo){
        this.repository= repo;
      this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<DettagliTecnici> findAll() {
        
        return repository.findAll();
    }

    @Override
    public DettagliTecnici findById(Long id) {
        Optional<DettagliTecnici> result = repository.findById(id);
        return result.get();
    }

    @Override
    public DettagliTecnici save(DettagliTecnici d) {
       String encodedOTP = this.passwordEncoder.encode(d.getOneTimePassword());
        d.setOneTimePassword(encodedOTP);
        DettagliTecnici detailsNew = repository.save(d);
        return   detailsNew;
    }

    @Override
    public Boolean update(DettagliTecnici d) {
       // String encodedOTP = this.passwordEncoder.encode(d.getOneTimePassword());
       // d.setOneTimePassword(encodedOTP);
        repository.save(d);
        return null;
    }

    @Override
    public Boolean delete(long id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public Boolean delete(DettagliTecnici d) {
        repository.delete(d);
        return null;
    }


    
}
