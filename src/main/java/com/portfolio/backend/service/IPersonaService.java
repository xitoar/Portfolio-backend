package com.portfolio.backend.service;

import com.portfolio.backend.model.Persona;

public interface IPersonaService {

    public void guardarPersona(Persona pers);

    public Persona buscarPersona(Long id);

    public Persona buscarXNombre(String usuario);

}
