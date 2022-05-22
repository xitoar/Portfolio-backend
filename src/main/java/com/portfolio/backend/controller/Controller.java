package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Experiencia;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.model.Proyectos;
import com.portfolio.backend.service.IEducacionService;
import com.portfolio.backend.service.IExperienciaService;
import com.portfolio.backend.service.IPersonaService;
import com.portfolio.backend.service.IProyectosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/info/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable Long id) {
        return persoServ.buscarPersona(id);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody Persona pers) {
        return persoServ.login(pers);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/nuevo")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/nuevo/educacion")
    @ResponseBody
    public List<Educacion> agregarPersona(@RequestBody Educacion edu) {
        return eduServ.crearEducacion(edu);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/borrarEdu/{id}")
    @ResponseBody
    public List<Educacion> borrarPersona(@PathVariable Long id) {
        return eduServ.borrarEducacion(id);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/nuevo/proyecto")
    @ResponseBody
    public List<Proyectos> agregarProyecto(@RequestBody Proyectos proy) {
        return proyServ.crearProyecto(proy);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/borrarProy/{id}")
    @ResponseBody
    public List<Proyectos> borrarProyecto(@PathVariable Long id) {
        return proyServ.borrarProyecto(id);
    }

    @CrossOrigin("http://localhost:4200")
    @PostMapping("/nuevo/experiencia")
    @ResponseBody
    public List<Experiencia> agregarExperiencia(@RequestBody Experiencia exp) {
        return expServ.crearExperiencia(exp);
    }

    @CrossOrigin("http://localhost:4200")
    @DeleteMapping("/borrarExp/{id}")
    @ResponseBody
    public List<Experiencia> borrarExperiencia(@PathVariable Long id) {
        return expServ.borrarExperiencia(id);
    }
}
