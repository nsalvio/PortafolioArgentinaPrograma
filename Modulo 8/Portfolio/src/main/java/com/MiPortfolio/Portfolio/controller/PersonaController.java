package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.service.ExperienciaService;
import com.MiPortfolio.Portfolio.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //capa controladora, atiende las solicitudes entrantes
@RequestMapping ("/persona")
@CrossOrigin(origins = "*")
public class PersonaController {

@Autowired
    private PersonaService personaService;
    private ExperienciaService experienciaService;

    @PostMapping ("/new") //guarda Persona en BD
    public void guardar(@RequestBody Persona pers)    
    {
        personaService.savePersona(pers);
    }
    
    @GetMapping ("/ver") //busca y trae el dato Persona desde la BD
    @ResponseBody
    public List<Persona> getPersonas () {   
        return personaService.getPersonas();
    }
    
    @GetMapping ("/ver/{id}") //busca y trae el dato Persona desde la BD
    @ResponseBody
    public Persona getPersona (@PathVariable Long id) {   
        Persona pers =  personaService.findPersona(id);
        pers.setExperienciaLaboral(null);
        pers.setEducacion(null);
        pers.setSkills(null);
        
        return pers;
    }
    
    @DeleteMapping ("/delete/{id}") //borra Persona mediante su id
    public void deletePersona (@PathVariable Long id){
        personaService.deletePersona(id);        
    }
    
    @PutMapping ("/editar/{id}") //edita el contenido de Persona
    public Persona  editPersona( @PathVariable Long id,
                                 @RequestBody Persona pers
            ) {
 
    Persona personaGuardada = personaService.findPersona(id);
   
    if(personaGuardada == null)
        return null;
            
    personaGuardada.setNombre(pers.getNombre());
    personaGuardada.setApellido(pers.getApellido());
    personaGuardada.setSobreMi(pers.getSobreMi());
    personaGuardada.setProvinciaYPais(pers.getProvinciaYPais());
   
    personaService.savePersona(personaGuardada);
   
    return personaGuardada;
    
    }
}
    
   