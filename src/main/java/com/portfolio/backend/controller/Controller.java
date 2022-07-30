package com.portfolio.backend.controller;

import com.portfolio.backend.DTO.JWTDTO;
import com.portfolio.backend.DTO.PersonaDTO;
import com.portfolio.backend.Security.JWTService;
import com.portfolio.backend.model.DatosBlandos;
import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.model.Proyectos;
import com.portfolio.backend.model.Usuario;
import com.portfolio.backend.service.IDatosBlandosService;
import com.portfolio.backend.service.IEducacionService;
import com.portfolio.backend.service.IExperienciaService;
import com.portfolio.backend.service.IPersonaService;
import com.portfolio.backend.service.IProyectosService;
import com.portfolio.backend.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    IPersonaService persoServ;
    @Autowired
    IEducacionService eduServ;
    @Autowired
    IExperienciaService expServ;
    @Autowired
    IProyectosService proyServ;
    @Autowired
    IUsuarioService userServ;
    @Autowired
    IDatosBlandosService datosServ;
    @Autowired
    JWTService jwt;
    @Autowired
    AuthenticationManager auth;

    @GetMapping("/info/{id}")
    @ResponseBody
    public PersonaDTO verPersona(@PathVariable Long id) {
        return new PersonaDTO(persoServ.buscarPersona(id));
    }

    @PostMapping("/login")
    @ResponseBody
    public JWTDTO login(@RequestBody Usuario usuario) {       
        Authentication authe = auth.authenticate(new UsernamePasswordAuthenticationToken(
                usuario.getUsuario(), usuario.getPassword()));
        JWTDTO token = new JWTDTO(jwt.crearJWT(authe));       
        return token;        
    }
    
    @PostMapping("/crear")
    public void crearUsuario(@RequestBody Usuario usuario) {
        userServ.crearPersona(usuario);
    }

    @PostMapping("/nuevo")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.guardarPersona(pers);
    }

    @PostMapping("/nuevo/educacion")
    @ResponseBody
    public List<Educacion> agregarEducacion(@RequestBody Educacion edu) {
        return eduServ.crearEducacion(edu);
    }

    @DeleteMapping("/borrarEdu/{id}")
    @ResponseBody
    public List<Educacion> borrarEducacion(@PathVariable Long id) {
        return eduServ.borrarEducacion(id);
    }

    @PostMapping("/nuevo/proyecto")
    @ResponseBody
    public List<Proyectos> agregarProyecto(@RequestBody Proyectos proy) {
        return proyServ.crearProyecto(proy);
    }

    @DeleteMapping("/borrarProy/{id}")
    @ResponseBody
    public List<Proyectos> borrarProyecto(@PathVariable Long id) {
        return proyServ.borrarProyecto(id);
    }

    @PostMapping("/nuevo/experiencia")
    @ResponseBody
    public List<Experiencia> agregarExperiencia(@RequestBody Experiencia exp) {
        return expServ.crearExperiencia(exp);
    }

    @DeleteMapping("/borrarExp/{id}")
    @ResponseBody
    public List<Experiencia> borrarExperiencia(@PathVariable Long id) {
        return expServ.borrarExperiencia(id);
    }
    
    @PostMapping("/nuevo/datosBlandos")
    @ResponseBody
    public List<DatosBlandos> agregarExperiencia(@RequestBody DatosBlandos datosBlandos) {
        return datosServ.crearDatosBlandos(datosBlandos) ;
    }

    @DeleteMapping("/borrarDatosBlandos/{id}")
    @ResponseBody
    public List<DatosBlandos> borrarDatosBlandos(@PathVariable Long id) {
        return datosServ.borrarDatosBlandos(id);
    }
}
