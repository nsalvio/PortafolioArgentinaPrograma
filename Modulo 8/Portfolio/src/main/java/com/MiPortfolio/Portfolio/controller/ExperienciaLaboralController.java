package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.service.ExperienciaService;
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
@RequestMapping("persona/{idPersona}/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaLaboralController {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private ExperienciaService experienciaService;

    @PutMapping("/new") //agrega experiencia mediante la búsqueda de Persona por id
    public void agregarExperienciaLaboral(@PathVariable Long idPersona,
            @RequestBody com.MiPortfolio.Portfolio.model.ExperienciaLaboral exp) {
        Persona personaGuardada = personaService.findPersona(idPersona);

        if (personaGuardada == null) {
            return;
        }

        exp.setPersona(personaGuardada);

        experienciaService.saveExperienciaLaboral(exp);
    }

    @GetMapping("/ver") //busca y trae experiencia laboral de Persona
    @ResponseBody
    public List<ExperienciaLaboral> findExperienciaLaboral(@PathVariable Long idPersona) {
        List<ExperienciaLaboral> experiencia = experienciaService.getExperienciaLaboral(idPersona);
        
        for (Iterator<ExperienciaLaboral> iterator = experiencia.iterator(); iterator.hasNext();) {
            ExperienciaLaboral next = iterator.next();
            next.getPersona(null);
        }
        
        return experiencia;
    }

    @GetMapping("/ver/{id}") //busca y trae la lista de experiencia laboral de idPersona
    @ResponseBody
    public ExperienciaLaboral findExperienciaLaboral(
            @PathVariable Long idPersona,
            @PathVariable Long id) {
        ExperienciaLaboral experiencia = experienciaService.findExperienciaLaboral(id);
        experiencia.getPersona(null);
        return experiencia;
    }

    @DeleteMapping("/delete/{id}")//borra experiencia mediante el id de Persona
    public void deleteExperienciaLaboral(@PathVariable Long id) {
        experienciaService.borrarExperienciaLaboral(id);
    }
}
                
              