package com.MiPortfolio.Portfolio.service;

import com.MiPortfolio.Portfolio.model.Skills;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface SkillsService {
    
   //borra Skill
   public void borrarSkill(Long id);
    
   //guarda Skill
   public void saveSkill(Skills ski);
   
   //busca una Skill por id
   public Skills findSkill(Long id);
   
   //obtiene una lista de todas las Skills 
   public List<Skills> getSkills(Long idPersona);    
    
}
