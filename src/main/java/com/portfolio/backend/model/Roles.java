
package com.portfolio.backend.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Setter;

@Entity
@Setter
public class Roles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique=true)    
    String rol;
    @ManyToMany(mappedBy = "roles")
    List <Persona> users;

    public Roles(Long id, String rol, List<Persona> users) {
        this.id = id;
        this.rol = rol;
        this.users = users;
    }   
 
    public Roles() {
    }

    public Roles(Long id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }
    
    public String getRol() {
        return rol;
    }
}
