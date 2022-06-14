package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.repository.IExperienciaLaboralRepository;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import com.MiPortfolio.Portfolio.service.ExperienciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExperienciaServicioImplementac implements ExperienciaService{
    
    @Autowired //inyecta una dependencia dentro de otra
    public IPersonaRepository personaRepo;
    @Autowired //inyecta una dependencia dentro de otra
    public IExperienciaLaboralRepository expRepo;

    public ExperienciaServicioImplementac() {
    }
    
    @Override
           //método para borrar Experiencia Laboral
    public void borrarExperienciaLaboral(Long id) {
        ExperienciaLaboral exp= expRepo.getById(id);
        Persona pers = personaRepo.findById(exp.getPersona().getId()).orElse(null);
        pers.getExperienciaLaboral().remove(exp);
        personaRepo.save(pers);        
        expRepo.delete(exp);                
    }

    @Override
            //método para guardar Experiencia Laboral
     public void saveExperienciaLaboral(ExperienciaLaboral exp) {
        expRepo.save(exp);
    }

    @Override
            //método para encontrar y traer Experiencia Laboral con Id
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
            //método para listar toda la Experiencia Laboral
    public List<ExperienciaLaboral> getExperienciaLaboral(Long idPersona) {
        return expRepo.findByIdPersona(idPersona);
    }
    
}
