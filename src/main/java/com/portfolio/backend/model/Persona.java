package com.portfolio.backend.model;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String usuario;
    private String password;
    @Lob
    private String imagen;
    @OneToMany(cascade = ALL, mappedBy = "persona")
    private List<Educacion> educacion;

    public Persona() {
    }

    public Persona(Long id, String nombre, String usuario, String password, String imagen, List<Educacion> educacion) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.imagen = imagen;
        this.educacion = educacion;
    }

    

}
