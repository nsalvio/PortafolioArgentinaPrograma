package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.Educacion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository //crea un repositorio que hereda del repositorio de JPA
public interface IEducacionRepository extends JpaRepository<Educacion, Long> {
    @Query("select edu from Educacion edu where edu.persona.id = :idPersona")
    List<Educacion> findByIdPersona(@Param("idPersona") Long idPersona);
}
