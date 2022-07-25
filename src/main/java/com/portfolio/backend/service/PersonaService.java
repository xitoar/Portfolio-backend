package com.portfolio.backend.service;


import com.portfolio.backend.model.Persona;

import com.portfolio.backend.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    PersonaRepository persoRepo;

    @Override
    public void crearPersona(Persona pers) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        pers.setPassword(encoder.encode(pers.getPassword()));
        persoRepo.save(pers);
    }

    @Override
    public Persona buscarPersona(Long id) {         
        return persoRepo.findById(id).orElse(null);         
    }

    @Override
    public boolean login(Persona pers) {
        List<Persona> personas = persoRepo.findAll();
        boolean aprobado = false;
        for (Persona persona : personas) {            
            if (persona.getUsuario().equals(pers.getUsuario()) && persona.getPassword().equals(pers.getPassword())) {
                aprobado = true;
                break;
            }
        }
        return aprobado;
    }

    @Override
    public Persona buscarXNombre(String usuario) {        
        return persoRepo.findByUsuario(usuario).orElse(null);
    }

}
