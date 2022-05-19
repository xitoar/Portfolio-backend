package com.portfolio.backend.service;

import com.portfolio.backend.model.Proyectos;
import com.portfolio.backend.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService {

    @Autowired
    ProyectosRepository proRepo;

    @Override
    public List<Proyectos> crearProyecto(Proyectos proy) {
        proRepo.save(proy);
        List<Proyectos> lista = buscarProyectosTotal();
        return lista;
    }

    @Override
    public List<Proyectos> buscarProyectosTotal() {
        return proRepo.findAll();
    }

    @Override
    public List<Proyectos> borrarProyecto(Long id) {
        proRepo.deleteById(id);
        List<Proyectos> lista = buscarProyectosTotal();
        return lista;
    }

}
