package com.MiPortfolio.Portfolio.controller;

import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.model.Skills;
import com.MiPortfolio.Portfolio.service.PersonaService;
import com.MiPortfolio.Portfolio.service.SkillsService;
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
@RequestMapping("persona/{idPersona}/Skills")
@CrossOrigin(origins = "*")
public class SkillsController {
    
    @Autowired
    private PersonaService personaService;

    @Autowired
    private SkillsService skillsService;

    @PutMapping("/new") //agrega skills mediante la búsqueda de Persona por id
    public void agregarSkills(@PathVariable Long idPersona,
            @RequestBody com.MiPortfolio.Portfolio.model.Skills ski) {
        Persona personaGuardada = personaService.findPersona(idPersona);

        if (personaGuardada == null) {
            return;
        }

        ski.setPersona(personaGuardada);

        skillsService.saveSkill(ski);
    }

    @GetMapping("/ver") //busca y trae skill de Persona
    @ResponseBody
    public List<Skills> findSkill(@PathVariable Long idPersona) {
        List<Skills> skills = skillsService.getSkills(idPersona);

        for (Iterator<Skills> iterator = skills.iterator(); iterator.hasNext();) {
            Skills next = iterator.next();
            next.setPersona(null);
        }

        return skills;
    }

    @GetMapping("/ver/{id}") //busca y trae la lista de skills de idPersona
    @ResponseBody
    public Skills findSkills(
            @PathVariable Long idPersona,
            @PathVariable Long id) {
        Skills skill = skillsService.findSkill(id);
        skill.setPersona(null);
        return skill;
    }

    @DeleteMapping("/delete/{id}")//borra skill mediante el id de Persona
    public void deleteSkill(@PathVariable Long id) {
        skillsService.borrarSkill(id);
    }
    
}
