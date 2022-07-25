
package com.portfolio.backend.service;

import com.portfolio.backend.model.Roles;


public interface IRolesService {
    
    public void agregarRol(Roles rol);
    
    public Roles verRol(Long id);
}
