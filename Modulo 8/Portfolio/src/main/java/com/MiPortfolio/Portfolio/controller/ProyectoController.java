package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.model.Proyecto;
import com.MiPortfolio.Portfolio.service.PersonaService;
import com.MiPortfolio.Portfolio.service.ProyectoService;
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

@RestController
@RequestMapping("persona/{idPersona}/Proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {
    
    @Autowired
    private PersonaService personaService;

    @Autowired
    private ProyectoService proyectoService;

    @PutMapping("/new") //agrega proyecto mediante la búsqueda de Persona por id
    public void agregarProyecto(@PathVariable Long idPersona,
            @RequestBody com.MiPortfolio.Portfolio.model.Proyecto pro) {
        Persona personaGuardada = personaService.findPersona(idPersona);

        if (personaGuardada == null) {
            return;
        }

        pro.getPersona(personaGuardada);

        proyectoService.saveProyecto (pro);
    }

    @GetMapping("/ver") //busca y trae proyecto de Persona
    @ResponseBody
    public List<Proyecto> findProyecto (@PathVariable Long idPersona) {
        List<Proyecto> proyecto = proyectoService.getProyecto(idPersona);
        
        for (Iterator<Proyecto> iterator = proyecto.iterator(); iterator.hasNext();) {
            Proyecto next = iterator.next();
            next.getPersona(null);
        }
        
        return proyecto;
    }

    @GetMapping("/ver/{id}") //busca y trae la lista de proyectos de idPersona
    @ResponseBody
    public Proyecto findProyecto(
            @PathVariable Long idPersona,
            @PathVariable Long id) {
        Proyecto proyecto = proyectoService.findProyecto(id);
        proyecto.getPersona(null);
        return proyecto;
    }

    @DeleteMapping("/delete/{id}")//borra proyecto mediante el id de Persona
    public void deleteProyecto (@PathVariable Long id) {
        proyectoService.borrarProyecto(id);
    }
    
}
