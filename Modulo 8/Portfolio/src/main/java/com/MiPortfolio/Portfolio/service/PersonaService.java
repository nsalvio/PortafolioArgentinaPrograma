package com.MiPortfolio.Portfolio.service;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import com.MiPortfolio.Portfolio.model.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

@Service

public interface PersonaService {
    
    //trae una lista de personas
    public List<Persona> getPersonas();
    
    //guarda un objeto de tipo persona
    public void savePersona (Persona perso);
    
    //eliminar un objeto de tipo persona por medio de su id
    public void deletePersona (Long id);
    
    //buscar un objeto persona por medio de su id
    public Persona findPersona (Long id);
    
 }
