
package com.portfolio.backend.service;

import com.portfolio.backend.model.Educacion;
import java.util.List;

public interface IEducacionService {
    
    public void crearEducacion (Educacion edu);       
    
    public List <Educacion> buscarEducacionTotal();
}
