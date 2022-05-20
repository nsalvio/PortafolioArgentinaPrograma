
package com.MiPortfolio.Portfolio.model;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity

public class Educacion {

    private String carrera;   
    private Boolean estudiaActualmente;
    private String instituto;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;
    
    public Long idEducacion;
            
}

public Educacion {

}

public Educacion (Long idEducacion, String carrera, Boolean estudiaActualmente, String instituto, java.sql.Date fechaInicio, java.sql.Date fechaFin){
        this.idEducacion = idExperiencia;
        this.carrera = carrera;
        this.estudiaActualmente = estudiaActualmente;
        this.instituto = instituto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
}
