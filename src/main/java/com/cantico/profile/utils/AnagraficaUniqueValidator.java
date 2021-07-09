package com.cantico.profile.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cantico.profile.service.AnagraficaService;


public class AnagraficaUniqueValidator implements ConstraintValidator<Unique,String> {

    @Autowired
    private AnagraficaService service;

    @Override
    public void initialize(Unique unique) {
        unique.message();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (service != null && service.existsByEmail(email)) {
            return false;
        }
        return true;
    }
}
