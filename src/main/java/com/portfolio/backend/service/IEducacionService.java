
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public List<Educacion> crearEducacion (Educacion edu);       
    
    public List <Educacion> buscarEducacionTotal();
}
