-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema portfolio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `portfolio` DEFAULT CHARACTER SET utf8 ;
USE `portfolio` ;

-- -----------------------------------------------------
-- Table `portfolio`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`persona` (
  `idPersona` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_de_nacimiento` DATE NULL,
  `correo` VARCHAR(20) NULL,
  `telefono` VARCHAR(15) NULL,
  `sobre_mi` VARCHAR(200) NULL,
  `url_foto` VARCHAR(200) NULL,
  PRIMARY KEY (`idPersona`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`tipo empleo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`tipo empleo` (
  `id empleo` INT NOT NULL,
  `nombre_tipo` VARCHAR(45) NULL,
  PRIMARY KEY (`id empleo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`experiencia laboral`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`experiencia laboral` (
  `idExperiencia` INT NOT NULL,
  `nombreEmpresa` VARCHAR(45) NULL,
  `esTrabajoActual` TINYINT NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `descripcion` VARCHAR(200) NULL,
  `persona_idPersona` INT NOT NULL,
  `tipo empleo_id empleo` INT NOT NULL,
  PRIMARY KEY (`idExperiencia`, `persona_idPersona`, `tipo empleo_id empleo`),
  INDEX `fk_experiencia laboral_persona1_idx` (`persona_idPersona` ASC) VISIBLE,
  INDEX `fk_experiencia laboral_tipo empleo1_idx` (`tipo empleo_id empleo` ASC) VISIBLE,
  CONSTRAINT `fk_experiencia laboral_persona1`
    FOREIGN KEY (`persona_idPersona`)
    REFERENCES `portfolio`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_experiencia laboral_tipo empleo1`
    FOREIGN KEY (`tipo empleo_id empleo`)
    REFERENCES `portfolio`.`tipo empleo` (`id empleo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`educacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`educacion` (
  `ideducacion` INT NOT NULL,
  `carrera` VARCHAR(45) NULL,
  `esEstudioActual` TINYINT NULL,
  `instituto` VARCHAR(45) NULL,
  `logoInstituto` VARCHAR(100) NULL,
  `fechaInicio` DATE NULL,
  `fechaFin` DATE NULL,
  `persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`ideducacion`, `persona_idPersona`),
  INDEX `fk_educacion_persona1_idx` (`persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_educacion_persona1`
    FOREIGN KEY (`persona_idPersona`)
    REFERENCES `portfolio`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`proyectos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`proyectos` (
  `idproyectos` INT NOT NULL,
  `nombreDelProyecto` VARCHAR(45) NULL,
  `fechaDeRealizacioin` DATE NULL,
  `descripción` VARCHAR(150) NULL,
  `link` VARCHAR(45) NULL,
  `persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idproyectos`, `persona_idPersona`),
  INDEX `fk_proyectos_persona1_idx` (`persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_proyectos_persona1`
    FOREIGN KEY (`persona_idPersona`)
    REFERENCES `portfolio`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `portfolio`.`tecnologias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `portfolio`.`tecnologias` (
  `idtecnologias` INT NOT NULL,
  `programaOlenguaje` VARCHAR(45) NULL,
  `gradoDeDominio` VARCHAR(45) NULL,
  `persona_idPersona` INT NOT NULL,
  PRIMARY KEY (`idtecnologias`, `persona_idPersona`),
  INDEX `fk_tecnologias_persona1_idx` (`persona_idPersona` ASC) VISIBLE,
  CONSTRAINT `fk_tecnologias_persona1`
    FOREIGN KEY (`persona_idPersona`)
    REFERENCES `portfolio`.`persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
