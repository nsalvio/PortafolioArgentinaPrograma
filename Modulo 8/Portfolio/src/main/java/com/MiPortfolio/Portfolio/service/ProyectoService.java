package com.MiPortfolio.Portfolio.service;

import com.MiPortfolio.Portfolio.model.Proyecto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ProyectoService {
    
   //borra proyecto
   public void borrarProyecto (Long id);
    
   //guarda proyecto 
   public void saveProyecto (Proyecto pro);
   
   //busca un proyecto por id
   public Proyecto findProyecto (Long id);
   
   //obtiene una lista de todos los proyectos
   public List<Proyecto> getProyecto (Long idPersona);    

}

    

