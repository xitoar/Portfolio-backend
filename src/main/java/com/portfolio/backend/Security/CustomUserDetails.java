
package com.portfolio.backend.Security;

import com.portfolio.backend.DTO.UsuarioDTO;
import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService{
    
    @Autowired
    IUsuarioService userServ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userServ.buscarXUsuario(username);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);        
        return usuarioDTO;
    }
    
}
