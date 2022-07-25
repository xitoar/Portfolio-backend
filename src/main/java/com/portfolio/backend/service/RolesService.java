
package com.portfolio.backend.service;
 
import com.portfolio.backend.model.Roles;
import com.portfolio.backend.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService implements IRolesService{
    
    @Autowired
    RolesRepository rolRepo;

    @Override
    public void agregarRol(Roles rol) {
        rolRepo.save(rol);
    }

    @Override
    public Roles verRol(Long id) {
        return rolRepo.findById(id).orElse(null);
    }
    
}
