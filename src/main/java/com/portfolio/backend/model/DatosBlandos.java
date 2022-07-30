
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class DatosBlandos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Lob
    private String imagen;
    private Long valor;
    private String coemntario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persId")
    private Persona persona;

    public DatosBlandos() {
    }

    public DatosBlandos(Long id, String titulo, String imagen, Long valor, String coemntario, Persona persona) {
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.valor = valor;
        this.coemntario = coemntario;
        this.persona = persona;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public Long getValor() {
        return valor;
    }

    public String getCoemntario() {
        return coemntario;
    }

    public Persona getPersona() {
        Persona pers = new Persona(persona.getId());        
        return pers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public void setCoemntario(String coemntario) {
        this.coemntario = coemntario;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
    
}
