package com.portfolio.backend.DTO;

import com.portfolio.backend.model.Roles;
import com.portfolio.backend.model.Usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
public class UsuarioDTO implements UserDetails {

    private String username;
    private String password;
    private List<Roles> roles;   

    public UsuarioDTO(Usuario usuario) {
        this.username = usuario.getUsuario();
        this.password = usuario.getPassword();
        this.roles = usuario.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auth = new ArrayList<>();
        for (Roles rol : roles) {
            auth.add(new SimpleGrantedAuthority(rol.getRol()));
        }
        return auth;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
