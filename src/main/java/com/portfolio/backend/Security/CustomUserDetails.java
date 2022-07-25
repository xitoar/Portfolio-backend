
package com.portfolio.backend.Security;

import com.portfolio.backend.DTO.UsuarioDTO;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService{
    
    @Autowired
    IPersonaService persoServ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona perso = persoServ.buscarXNombre(username);
        UsuarioDTO usuario = new UsuarioDTO(perso);        
        return usuario;
    }
    
}
