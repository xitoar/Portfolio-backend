
package com.portfolio.backend.DTO;

import com.portfolio.backend.model.DatosBlandos;
import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.model.Proyectos;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaDTO {
    
    private Long id;
    private String nombre;    
    private String mail;
    private String facebook;
    private String linkedin;    
    private String imagen;    
    private List<Educacion> educacion;    
    private List<Experiencia> experiencia;    
    private List<Proyectos> proyectos;
    private List<DatosBlandos> datosBlandos;      

    public PersonaDTO(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.mail = persona.getMail();
        this.facebook = persona.getFacebook();
        this.linkedin = persona.getLinkedin();
        this.imagen = persona.getImagen();
        this.educacion = persona.getEducacion();
        this.experiencia = persona.getExperiencia();
        this.proyectos = persona.getProyectos();
        this.datosBlandos = persona.getDatosBlandos();
    }
    
    
}
