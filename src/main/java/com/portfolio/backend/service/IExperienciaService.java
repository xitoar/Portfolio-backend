package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public List<Experiencia> crearExperiencia(Experiencia exp);

    public List<Experiencia> buscarExperienciaTotal();

    public List<Experiencia> borrarExperiencia(Long id);

}
