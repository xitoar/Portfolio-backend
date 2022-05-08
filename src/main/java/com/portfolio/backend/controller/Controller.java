
package com.portfolio.backend.controller;


import com.portfolio.backend.DTO.DTOTotal;
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
    
    @Autowired IPersonaService persoServ;
    @Autowired IEducacionService eduServ;
    
  @CrossOrigin ("http://localhost:4200")
  @GetMapping ("/info/{id}")
  @ResponseBody
  public DTOTotal verPersona(@PathVariable Long id){      
      Persona pers = persoServ.buscarPersona(id);
      List <Educacion> educacion = eduServ.buscarEducacionTotal();
      DTOTotal total = new DTOTotal();      
      total.setId(pers.getId());
      total.setNombre(pers.getNombre());
      total.setEducacion(educacion);      
      return total;
  }
  
  @CrossOrigin ("http://localhost:4200")
  @PostMapping ("/nuevo")
    public void agregarPersona (@RequestBody Persona pers){
      persoServ.crearPersona(pers);
    }
    
  @CrossOrigin ("http://localhost:4200")
  @PostMapping ("/nuevo/educacion")
    public void agregarPersona (@RequestBody Educacion edu){
      eduServ.crearEducacion(edu);
    }
    
}
