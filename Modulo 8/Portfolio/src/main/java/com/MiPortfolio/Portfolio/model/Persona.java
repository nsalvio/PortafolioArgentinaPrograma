package com.MiPortfolio.Portfolio.model; //modelado de clases

import com.sun.istack.NotNull;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //mapea la entidad
@Table(name = "persona") //crea y nombra la tabla persona
@AllArgsConstructor //constructor con argumentos
@NoArgsConstructor //constructor vacío
@Data //crea getters y setters

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull //el campo no puede estar vacío
    
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    private String sobreMi;
    private String provinciaYPais;
    private String fotoPerfil;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="persona",cascade = CascadeType.ALL)
    private List<ExperienciaLaboral> experienciaLaboral;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="persona",cascade = CascadeType.ALL)
    private List<Educacion> educacion;

    @OneToMany(fetch = FetchType.LAZY,mappedBy="persona",cascade = CascadeType.ALL)
    private List<Proyecto> proyecto;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy="persona",cascade = CascadeType.ALL)
    private List<Skills> skills;

    public Persona(Long id, String nombre, String apellido, String sobreMi, String provinciaYPais, String fotoPerfil, List<ExperienciaLaboral> experienciaLaboral, List<Educacion> educacion, List<Proyecto> proyecto, List<Skills> skills) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.sobreMi = sobreMi;
        this.provinciaYPais = provinciaYPais;
        this.fotoPerfil = fotoPerfil;
        this.experienciaLaboral = experienciaLaboral;
        this.educacion = educacion;
        this.proyecto = proyecto;
        this.skills = skills;
    }
}
