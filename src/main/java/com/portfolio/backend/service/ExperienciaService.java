package com.portfolio.backend.service;

import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    ExperienciaRepository expRepo;

    @Override
    public List<Experiencia> crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
        List<Experiencia> lista = buscarExperienciaTotal();
        return lista;
    }

    @Override
    public List<Experiencia> buscarExperienciaTotal() {
        return expRepo.findAll();
    }

    @Override
    public List<Experiencia> borrarExperiencia(Long id) {
        expRepo.deleteById(id);
        List<Experiencia> lista = buscarExperienciaTotal();
        return lista;
    }

}
