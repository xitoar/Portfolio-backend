package com.portfolio.backend.model;

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
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String usuario;
    private String password;
    private String mail;
    private String facebook;
    private String linkedin;
    @Lob
    private String imagen;
    @OneToMany(cascade = ALL, mappedBy = "persona")
    private List<Educacion> educacion;
    @OneToMany(cascade = ALL, mappedBy = "persona")
    private List<Experiencia> experiencia;
    @OneToMany(cascade = ALL, mappedBy = "persona")
    private List<Proyectos> proyectos;

    public Persona() {
    }

    public Persona(Long id, String nombre, String usuario, String password, String mail, String facebook, String linkedin, String imagen, List<Educacion> educacion, List<Experiencia> experiencia, List<Proyectos> proyectos) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.mail = mail;
        this.facebook = facebook;
        this.linkedin = linkedin;
        this.imagen = imagen;
        this.educacion = educacion;
        this.experiencia = experiencia;
        this.proyectos = proyectos;
    }

    public Persona(Long id, String nombre, String mail, String facebook, String linkedin) {
        this.id = id;
        this.nombre = nombre;
        this.mail = mail;
        this.facebook = facebook;
        this.linkedin = linkedin;

    }

    public Persona(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Persona(Long id) {
        this.id = id;
    }     

}
