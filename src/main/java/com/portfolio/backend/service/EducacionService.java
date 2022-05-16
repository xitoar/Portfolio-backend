
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> crearEducacion(Educacion edu) {
        eduRepo.save(edu);
        List<Educacion> lista = buscarEducacionTotal();         
        return lista;
                
    }

    @Override
    public List <Educacion> buscarEducacionTotal() {
        return eduRepo.findAll();
    }
    
    
}
