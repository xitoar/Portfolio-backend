
package com.portfolio.backend.service;

import com.portfolio.backend.model.DatosBlandos;

import java.util.List;


public interface IDatosBlandosService {
    
    public List<DatosBlandos> crearDatosBlandos (DatosBlandos datosBlandos);       
    
    public List <DatosBlandos> buscarDatosBlandosTotal();
    
    public List <DatosBlandos> borrarDatosBlandos(Long id);
    
}
