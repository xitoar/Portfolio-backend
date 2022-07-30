
package com.portfolio.backend.repository;

import com.portfolio.backend.model.DatosBlandos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosBlandosRepository extends JpaRepository <DatosBlandos, Long> {
    
}
