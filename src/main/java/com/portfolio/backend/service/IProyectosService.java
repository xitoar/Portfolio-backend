package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyectos;
import java.util.List;

public interface IProyectosService {

    public List<Proyectos> crearProyecto(Proyectos proy);

    public List<Proyectos> buscarProyectosTotal();

    public List<Proyectos> borrarProyecto(Long id);

}
