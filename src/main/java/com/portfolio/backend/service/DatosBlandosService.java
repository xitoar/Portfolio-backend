
package com.portfolio.backend.service;

import com.portfolio.backend.model.DatosBlandos;
import com.portfolio.backend.repository.DatosBlandosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosBlandosService implements IDatosBlandosService{
    
    @Autowired
    DatosBlandosRepository datosRepo;
    
    @Override
    public List<DatosBlandos> crearDatosBlandos(DatosBlandos datosBlandos) {
        datosRepo.save(datosBlandos);
        List<DatosBlandos> lista = buscarDatosBlandosTotal();
        return lista;
    }

    @Override
    public List<DatosBlandos> buscarDatosBlandosTotal() {
        return datosRepo.findAll();
    }

    @Override
    public List<DatosBlandos> borrarDatosBlandos(Long id) {
        datosRepo.deleteById(id);
        List<DatosBlandos> lista = buscarDatosBlandosTotal();
        return lista;        
    }
    
}
