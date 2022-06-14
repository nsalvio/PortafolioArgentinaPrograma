package com.MiPortfolio.Portfolio.model;

import com.sun.istack.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //mapea la entidad
@Table(name = "educación") //crea y nombra la tabla educación
@AllArgsConstructor //constructor con argumentos
@NoArgsConstructor //constructor vacío
@Data //gatters y setters
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long Id;

    private String carrera;
    private Boolean estudiaActualmente;
    private String instituto;
    private java.sql.Date fechaInicio;
    private java.sql.Date fechaFin;

    public Long idEducacion;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public Educacion(Long idEducacion, String carrera, Boolean estudiaActualmente, String instituto, java.sql.Date fechaInicio, java.sql.Date fechaFin) {
        this.idEducacion = idEducacion;
        this.carrera = carrera;
        this.estudiaActualmente = estudiaActualmente;
        this.instituto = instituto;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }
}
