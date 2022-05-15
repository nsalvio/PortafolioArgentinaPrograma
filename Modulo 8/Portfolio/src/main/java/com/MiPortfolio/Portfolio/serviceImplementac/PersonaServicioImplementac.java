package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.repository.IExperienciaLaboralRepository;
import com.MiPortfolio.Portfolio.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import java.util.Optional;
import java.util.Set;

@Service
public class PersonaServicioImplementac implements PersonaService{
    
@Autowired //inyecta una dependencia dentro de otra
    private IPersonaRepository persoRepo;
@Autowired //inyecta una dependencia dentro de otra
    private IExperienciaLaboralRepository expRepo;

    @Override
        //método para buscar y retornar lista de Personas
    public List<Persona> getPersonas() {
           return persoRepo.findAll();            
    }

    @Override
       //método para guardar Persona
    public void savePersona(Persona per) {
           persoRepo.save(per);    
    }

    @Override
        //método para borrar Persona por medio de su id
    public void deletePersona(Long id) {
           persoRepo.deleteById(id);
    }

    @Override
       //método para buscar y retornar Persona por id
      //sino la encuentra, devuelve: Null
    public Persona findPersona(Long id) {
           return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void borrarExperienciaLaboral(Long id) {
        expRepo.deleteById(id);
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
    public Set<ExperienciaLaboral> getExperienciaLaboral(Long idPersona) {
    Persona persona = persoRepo.findById(idPersona).orElse(null);
    if(persona != null){
        return persona.getExperienciaLaboral();
    }
    
    return null;
    }
    
}
