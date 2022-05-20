package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.repository.IExperienciaLaboralRepository;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import com.MiPortfolio.Portfolio.service.ExperienciaService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author noeli
 */
@Service
public class ExperienciaServicioImplementac implements ExperienciaService{
    
    @Autowired
    public IPersonaRepository personaRepo;
    @Autowired
    public IExperienciaLaboralRepository expRepo;

    public ExperienciaServicioImplementac() {
    }
    
    @Override
    public void borrarExperienciaLaboral(Long id) {
        ExperienciaLaboral exp= expRepo.getById(id);
        Persona pers = personaRepo.findById(exp.getPersona().getId()).orElse(null);
        pers.getExperienciaLaboral().remove(exp);
        personaRepo.save(pers);        
        expRepo.delete(exp);                
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral exp) {
        expRepo.save(exp);
    }

    @Override
    public ExperienciaLaboral findExperienciaLaboral(Long id) {
        return expRepo.findById(id).orElse(null);
    }

    @Override
    public List<ExperienciaLaboral> getExperienciaLaboral(Long idPersona) {
        return expRepo.findByIdPersona(idPersona);
    }
    
}
