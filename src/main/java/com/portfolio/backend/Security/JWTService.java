package com.portfolio.backend.Security;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class JWTService {

    @Value("${JWTSECRET}")
    private String jwtSecret;
    @Value("${JWTTIME}")
    private int jwtTime;
    
    
    
    public String crearJWT(Authentication aute) {
        String token = com.auth0.jwt.JWT.create()
                .withExpiresAt(Date.from(Instant.now().plusSeconds(jwtTime)))
                .withIssuer("Helios")
                .withClaim("user", aute.getName())
                .withClaim("roles", aute.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(Algorithm.HMAC256(jwtSecret));
        return token;
    }

    public DecodedJWT verificarJWT(String authorization) {
        String token = authorization.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(jwtSecret);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }
    
    public String getUsuario(DecodedJWT jwt){
        String user = jwt.getClaim("user").asString();        
        return user;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities(DecodedJWT jwt){
        List<GrantedAuthority> auth = new ArrayList<>();
        List<String> roles = Arrays.asList(jwt.getClaim("roles").asArray(String.class)); 
        for (String rol : roles) {
            auth.add(new SimpleGrantedAuthority(rol));
        }
        return auth;
        
    }

}
