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
@Table(name ="Proyectos") //crea y nombra la tabla Proyectos
@AllArgsConstructor //constructor con argumentos
@NoArgsConstructor //constructor vacío
@Data //crea getters y setter
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //generacion de P.Key automática
    @NotNull //el campo no puede estar vacío
    
    private Long id;
    private String nombreDelProyecto;
    private java.sql.Date fechaDeRealizacion;
    private String descripcion;
    private String link;
    
    public Long idProyecto;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPersona")
    private Persona persona;
    
    public Proyecto (Long idProyecto, String nombreDelProyecto, java.sql.Date fechaDeRealizacion, String descripcion, String link){
    this.idProyecto = idProyecto;
    this.nombreDelProyecto = nombreDelProyecto;
    this.fechaDeRealizacion = fechaDeRealizacion;
    this.descripcion = descripcion;
    this.link = link;
    }

    public void getPersona(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
