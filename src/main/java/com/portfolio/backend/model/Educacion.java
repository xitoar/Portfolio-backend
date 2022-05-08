
package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String subtitulo;
    private String comentario;

    public Educacion() {
    }

    public Educacion(Long id, String titulo, String subtitulo, String comentario) {
        this.id = id;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.comentario = comentario;
    }
    
    
    
}
