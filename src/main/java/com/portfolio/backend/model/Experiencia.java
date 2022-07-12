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
public class Experiencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tarea;
    @Column(columnDefinition = "text")
    private String comentario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persId")
    private Persona persona;

    public Experiencia() {
    }

    public Experiencia(Long id, String tarea, String comentario, Persona persona) {
        this.id = id;
        this.tarea = tarea;
        this.comentario = comentario;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
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
