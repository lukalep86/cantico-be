package com.cantico.profile.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cantico.profile.model.Anagrafica;

@Service
public interface AnagraficaService {    


    public List<Anagrafica> findAll();
    public Anagrafica findById(Long id);
    public Anagrafica findByEmail(String email);
    public Anagrafica save(Anagrafica a);
    public Boolean update(Long id, Anagrafica anagrafica);
    public Anagrafica update(String email, Anagrafica anagrafica);
    public Boolean delete(long id);
    public Boolean deleteByEmail(String email);
    public boolean existsByEmail(String email);
    public Boolean checkOTP(String email, String OTP);
    public Boolean checkLoginPassword(String email, String password);
    public boolean isOTPExpires(Anagrafica a, long duration);

       

}
