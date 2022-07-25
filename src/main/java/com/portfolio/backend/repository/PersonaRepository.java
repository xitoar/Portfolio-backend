
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository <Persona, Long>{
    
    public Optional<Persona> findByUsuario(String nombre);
    
}
