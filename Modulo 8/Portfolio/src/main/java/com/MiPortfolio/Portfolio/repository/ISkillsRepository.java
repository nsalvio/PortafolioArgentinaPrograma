package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.Skills;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository //crea un repositorio que hereda del repositorio de JPA

public interface ISkillsRepository extends JpaRepository<Skills, Long>{
    @Query("select ski from Skills ski where ski.persona.id = :idPersona")
    List<Skills> findByIdPersona(@Param("idPersona") Long idPersona);
    
}
