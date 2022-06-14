package com.MiPortfolio.Portfolio.service;

import com.MiPortfolio.Portfolio.model.Educacion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EducacionService {
    
    //borra educación
   public void borrarEducacion (Long id);
    
   //guarda educación
   public void saveEducacion (Educacion edu);
   
   //busca una educación
   public Educacion findEducacion(Long id);
   
   //obtiene una lista de toda la educación
   public List<Educacion> getEducacion (Long idPersona);    
}




