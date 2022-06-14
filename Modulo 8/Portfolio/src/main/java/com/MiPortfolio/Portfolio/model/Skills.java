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
@Table(name ="skills") //crea y nombra la tabla Skills
@AllArgsConstructor //constructor con argumentos
@NoArgsConstructor //constructor vacío
@Data //crea getters y setter
public class Skills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    private String nombreSkill;
    private int procentaje;
    
    public Long idSkills;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    public Skills(Long idSkills, String nombreSkill, int Porcentaje) {
        this.idSkills = idSkills;
        this.nombreSkill = nombreSkill;
        this.procentaje = procentaje;
    }
}
