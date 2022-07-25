package com.portfolio.backend.Security;

import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    AuthenticationManager authentication;
    @Autowired
    CustomUserDetails userDetail;
    @Autowired
    JWTService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("AUTHORIZATION");
        if (token != null) {
            DecodedJWT jwtDeco = jwtService.verificarJWT(token);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(jwtService.getUsuario(jwtDeco), null, jwtService.getAuthorities(jwtDeco));
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(request, response);
    }

}
