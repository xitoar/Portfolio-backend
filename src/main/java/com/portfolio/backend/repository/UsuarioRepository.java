
package com.portfolio.backend.repository;



import com.portfolio.backend.model.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    public Optional<Usuario> findByUsuario(String usuario);
    
}
