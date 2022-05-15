package com.MiPortfolio.Portfolio.model; //modelado de clases

import com.sun.istack.NotNull;
import java.util.List;
import java.util.Set;
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
    private String sobreMi;
    private String provincia;
    
    @OneToMany(fetch = FetchType.EAGER,mappedBy="persona",cascade = CascadeType.ALL)
    private List<ExperienciaLaboral> experienciaLaboral;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String sobreMi, String provincia, Set<ExperienciaLaboral> experienciaLaboral) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sobreMi = sobreMi;
        this.provincia = provincia;
        this.experienciaLaboral = experienciaLaboral;
    }
}
