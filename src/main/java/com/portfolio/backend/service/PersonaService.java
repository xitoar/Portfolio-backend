package com.portfolio.backend.service;


import com.portfolio.backend.model.Persona;

import com.portfolio.backend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository persoRepo;    

    @Override
    public Persona buscarPersona(Long id) {         
        return persoRepo.findById(id).orElse(null);         
    }    

    @Override
    public Persona buscarXNombre(String usuario) {        
        return persoRepo.findByUsuario(usuario).orElse(null);
    }

    @Override
    public void guardarPersona(Persona pers) {        
        persoRepo.save(pers);
    }

}
