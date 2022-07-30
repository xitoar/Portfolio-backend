
package com.portfolio.backend.service;


import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    UsuarioRepository userRepo;    

    @Override
    public void crearPersona(Usuario usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        userRepo.save(usuario);
    }

    @Override
    public Usuario buscarXUsuario(String usuario) {
        return userRepo.findByUsuario(usuario).orElse(null);
    }
}
