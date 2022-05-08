
package com.portfolio.backend.DTO;

import com.portfolio.backend.model.Educacion;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DTOTotal {
    
    private Long id;
    private String nombre;
    private List <Educacion> educacion;

     public DTOTotal() {
    }
    
    public DTOTotal(Long id, String nombre, List<Educacion> educacion) {
        this.id = id;
        this.nombre = nombre;
        this.educacion = educacion;
    }

   
    
    
    
}
