package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

public class PersonaController {

@Autowired
    private PersonaService personaService;    

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
        return personaService.findPersona(id);
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
    personaGuardada.setProvincia(pers.getProvincia());
   
    personaService.savePersona(personaGuardada);
   
    return personaGuardada;
    
    }
    
    
    @PutMapping ("/{idPersona}/experiencia") //agrega experiencia
    public void agregarExperienciaLaboral(@PathVariable Long idPersona,
                                          @RequestBody ExperienciaLaboral exp){
        Persona personaGuardada = personaService.findPersona(idPersona);
   
        if(personaGuardada == null)
            return;
        
        exp.setPersona(personaGuardada);
        personaGuardada.getExperienciaLaboral().add(exp);
        
        personaService.savePersona(personaGuardada);
    }
}
//Falta el resto del CRUD de experiencia