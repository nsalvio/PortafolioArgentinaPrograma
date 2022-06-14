package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.model.Proyecto;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import com.MiPortfolio.Portfolio.repository.IProyectoRepository;
import com.MiPortfolio.Portfolio.service.ProyectoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoServicioImplementac implements ProyectoService {
    
    @Autowired //inyecta una dependencia dentro de otra
    public IPersonaRepository personaRepo;
    
    @Autowired //inyecta una dependencia dentro de otra
    public IProyectoRepository proRepo;
    
    public ProyectoServicioImplementac(){   
    }
    
    
    @Override
    public void borrarProyecto(Long id) {
        Proyecto pro = proRepo.getById(id);
        Persona pers = personaRepo.findById(pro.getPersona().getId()).orElse(null);
        pers.getProyecto().remove(pro);
        personaRepo.save(pers);        
        proRepo.delete(pro);      
    }    

    @Override
    public void saveProyecto(Proyecto pro) {
    proRepo.save(pro);
    }    

    @Override
    public Proyecto findProyecto(Long id) {
       return proRepo.findById(id).orElse(null);
    }

    @Override
    public List<Proyecto> getProyecto(Long idPersona) {
        return proRepo.findByIdPersona(idPersona);
    }
   
}
