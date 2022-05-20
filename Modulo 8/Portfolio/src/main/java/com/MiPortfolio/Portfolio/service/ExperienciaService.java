package com.MiPortfolio.Portfolio.service;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public interface ExperienciaService {

   //borra experiencia laboral
   public void borrarExperienciaLaboral(Long id);
    
   //guarda experiencia laboral 
   public void saveExperienciaLaboral(ExperienciaLaboral exp);
   
   //busca una experiencia laboral por id
   public ExperienciaLaboral findExperienciaLaboral(Long id);
   
   //obtiene una lista de toda la experiencia laboral
   public List<ExperienciaLaboral> getExperienciaLaboral(Long idPersona);    
}
