package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //crea un repositorio que hereda del repositorio de JPA
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    @Query("select pro from Proyecto pro where pro.persona.id = :idPersona")
    List<Proyecto> findByIdPersona(@Param("idPersona") Long idPersona); 
}
