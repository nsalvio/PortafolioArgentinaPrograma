package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //crea un repositorio que hereda del repositorio de JPA
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {
    
}
