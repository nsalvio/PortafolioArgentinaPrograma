package com.MiPortfolio.Portfolio.repository;

import com.MiPortfolio.Portfolio.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //crea un repositorio que hereda del repositorio de JPA
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
