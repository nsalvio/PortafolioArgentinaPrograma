package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.model.Skills;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import com.MiPortfolio.Portfolio.repository.ISkillsRepository;
import com.MiPortfolio.Portfolio.service.SkillsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsServicioImplementac implements SkillsService {
    
    @Autowired //inyecta una dependencia dentro de otra
    public IPersonaRepository personaRepo;
    @Autowired //inyecta una dependencia dentro de otra
    public ISkillsRepository skiRepo;

    public SkillsServicioImplementac() {
    }

    @Override
    public void borrarSkill(Long id) {
        Skills ski = skiRepo.getById(id);
        Persona pers = personaRepo.findById(ski.getPersona().getId()).orElse(null);
        pers.getSkills().remove(ski);
        personaRepo.save(pers);        
        skiRepo.delete(ski);                
    }

    @Override
    public void saveSkill(Skills ski) {
        skiRepo.save(ski);
    }

    @Override
    public Skills findSkill(Long id) {
        return skiRepo.findById(id).orElse(null);
    }

    @Override
    public List<Skills> getSkills(Long idPersona) {
        return skiRepo.findByIdPersona(idPersona);
    }

}
