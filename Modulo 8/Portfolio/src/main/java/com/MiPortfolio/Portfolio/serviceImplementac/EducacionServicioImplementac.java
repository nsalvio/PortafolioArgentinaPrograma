package com.MiPortfolio.Portfolio.serviceImplementac;

import com.MiPortfolio.Portfolio.model.Educacion;
import com.MiPortfolio.Portfolio.model.Persona;
import com.MiPortfolio.Portfolio.repository.IEducacionRepository;
import com.MiPortfolio.Portfolio.repository.IPersonaRepository;
import com.MiPortfolio.Portfolio.service.EducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionServicioImplementac implements EducacionService {

    @Autowired //inyecta una dependencia dentro de otra
    public IPersonaRepository personaRepo;
    
    @Autowired //inyecta una dependencia dentro de otra
    public IEducacionRepository eduRepo;
    
    public EducacionServicioImplementac (){
    }
    
    @Override 
           //método para borrar Educacion
        public void borrarEducacion(Long id) {
        Educacion edu = eduRepo.getById(id);
        Persona pers = personaRepo.findById(edu.getPersona().getId()).orElse(null);
        pers.getEducacion().remove(edu);
        personaRepo.save(pers);        
        eduRepo.delete(edu);                
    }
    
   @Override
            //método para guardar Educacion
   public void saveEducacion (Educacion edu) {
       eduRepo.save(edu);
   }
            
   @Override
            //método para encontrar una Educacion por Id
   public Educacion findEducacion(Long id){
       return eduRepo.findById(id).orElse(null);
   }
   
   @Override
            //método para encontrar una lista con todos los datos de Educacion
   public List<Educacion> getEducacion (Long idPersona){   
        return eduRepo.findByIdPersona(idPersona);
   }
    
}

