package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.Educacion;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.service.EducacionService;
import com.MiPortfolio.Portfolio.service.PersonaService;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //capa controladora, atiende las solicitudes entrantes
@RequestMapping("persona/{idPersona}/educacion")
@CrossOrigin(origins = "*")
public class EducacionController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private EducacionService educacionService;

    @PutMapping("/new") //agrega educación mediante la búsqueda de Persona por id
    public void agregarEducacion(@PathVariable Long idPersona,
            @RequestBody com.MiPortfolio.Portfolio.model.Educacion edu) {
        Persona personaGuardada = personaService.findPersona(idPersona);

        if (personaGuardada == null) {
            return;
        }

        edu.setPersona(personaGuardada);

        educacionService.saveEducacion(edu);
    }

    @GetMapping("/ver") //busca y trae educacion de Persona
    @ResponseBody
    public List<Educacion> findEducacion(@PathVariable Long idPersona) {
        List<Educacion> educacion = educacionService.getEducacion(idPersona);

        for (Iterator<Educacion> iterator = educacion.iterator(); iterator.hasNext();) {
            Educacion next = iterator.next();
            next.setPersona(null);
        }

        return educacion;
    }

    @GetMapping("/ver/{id}") //busca y trae la lista de educacion de idPersona
    @ResponseBody
    public Educacion findEducacion(
            @PathVariable Long idPersona,
            @PathVariable Long id) {
        Educacion educacion = educacionService.findEducacion(id);
        educacion.setPersona(null);
        return educacion;
    }

    @DeleteMapping("/delete/{id}")//borra educacion mediante el id de Persona
    public void deleteEducacion(@PathVariable Long id) {
        educacionService.borrarEducacion(id);
    }
}
