package com.portfolio.backend.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proyectos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(columnDefinition = "text")
    private String comentario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persId")
    private Persona persona;

    public Proyectos() {
    }

    public Proyectos(Long id, String titulo, String comentario, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.comentario = comentario;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Persona getPersona() {
        Persona pers = new Persona(persona.getId());
        return pers;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
