package com.portfolio.backend.controller;

import com.portfolio.backend.model.Educacion;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IEducacionService;
import com.portfolio.backend.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/info/{id}")
    @ResponseBody
    public Persona verPersona(@PathVariable Long id) {
        return persoServ.buscarPersona(id);
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
    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody Persona pers) {
        return persoServ.login(pers);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/borrarEdu/{id}")
    @ResponseBody
    public List<Educacion> borrarPersona(@PathVariable Long id) {
        return eduServ.borrarEducacion(id);
    }

}
