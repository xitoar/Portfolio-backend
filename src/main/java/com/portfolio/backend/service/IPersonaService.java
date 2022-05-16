
package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;


public interface IPersonaService {
    
    public void crearPersona (Persona pers);       
    
    public Persona buscarPersona (Long id);
    
    public boolean login(Persona pers);
    
}
