
package com.portfolio.backend.service;

import com.portfolio.backend.model.Usuario;


public interface IUsuarioService {
    
    public void crearPersona(Usuario usuario);
    
    public Usuario buscarXUsuario(String usuario);
    
}
