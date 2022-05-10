
package com.portfolio.backend.model;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;    
    @OneToMany(cascade=ALL, mappedBy="persona")    
    private List<Educacion> educacion;

    public Persona() {
    }

    public Persona(Long id, String nombre, List<Educacion> educacion) {
        this.id = id;
        this.nombre = nombre;
        this.educacion = educacion;
    }  
    
    
    
}
