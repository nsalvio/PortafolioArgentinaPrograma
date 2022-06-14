package com.MiPortfolio.Portfolio.model; //modelado de clases

import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //mapea la entidad
@Table(name = "experiencia_laboral") //crea y nombra la tabla persona
@AllArgsConstructor //constructor con argumentos
@NoArgsConstructor //constructor vacío
@Data //crea getters y setters
public class ExperienciaLaboral
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull //el campo no puede estar vacío
	public Long idExperiencia;
	public String nombreEmpresa;
	public boolean esTrabajoActual;
	public java.sql.Date fechaInicio;
	public java.sql.Date fechaFin;
	public String descripcion;
        
	public Long idEmpleo;
        
        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "idPersona")
        private Persona persona;

	public ExperienciaLaboral(Long idExperiencia_,String nombreEmpresa_,boolean esTrabajoActual_,java.sql.Date fechaInicio_,java.sql.Date fechaFin_,String descripcion_,Long idPersona_,Long idEmpleo_, Persona persona)
	{
		this.idExperiencia = idExperiencia_;
		this.nombreEmpresa = nombreEmpresa_;
		this.esTrabajoActual = esTrabajoActual_;
		this.fechaInicio = fechaInicio_;
		this.fechaFin = fechaFin_;
		this.descripcion = descripcion_;
		this.idEmpleo = idEmpleo_;
                this.persona = persona;
	}

    public void getPersona(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
