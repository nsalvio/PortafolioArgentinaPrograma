package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //crea un repositorio que hereda del repositorio de JPA
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {
    @Query("select exp from ExperienciaLaboral exp where exp.persona.id = :idPersona")
    List<ExperienciaLaboral> findByIdPersona(@Param("idPersona") Long idPersona);
}
