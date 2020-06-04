-- MySQL Script generated by MySQL Workbench
-- Wed Sep 25 17:03:56 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bds_consola_universal
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bds_consola_universal` ;

-- -----------------------------------------------------
-- Schema bds_consola_universal
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bds_consola_universal` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `bds_consola_universal` ;

-- -----------------------------------------------------
-- Table `bds_consola_universal`.`cfConfigurations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`cfConfigurations` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`cfConfigurations` (
  `IdConfiguration` INT(11) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(25) NULL DEFAULT NULL,
  `Value` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`IdConfiguration`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;

INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('CompanyEncryptCode', '~KöAtcHy¬');
INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('CompanyName', 'Köatchy');
INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('EmailHost', 'smtp.gmail.com');
INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('EmailPort', '587');
INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('EmailFromAccout', 'abarrios7007@gmail.com');
INSERT INTO `bds_consola_universal`.`cfConfigurations` (`Description`, `Value`) VALUES ('AutorizationRequest', 'wDo3rXrE/');


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctUserAreas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctUserAreas` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctUserAreas` (
  `IdUserArea` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Notify` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdUserArea`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Infraestructura', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Negocio', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Desarrollo BE', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Desarrollo Apps', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('QA', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Soporte', 'Y');
INSERT INTO `bds_consola_universal`.`ctUserAreas` (`name`, `Notify`) VALUES ('Líder', 'Y');


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctUsers` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctUsers` (
  `IdUser` INT(11) NOT NULL AUTO_INCREMENT,
  `IdUserArea` INT(11) NOT NULL,
  `Password` VARCHAR(150) NOT NULL,
  `Name` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(150) NOT NULL,
  `Superuser` CHAR(1) NOT NULL,
  `Unavaibled` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdUser`),
  CONSTRAINT `FK_User_Area`
    FOREIGN KEY (`IdUserArea`)
    REFERENCES `bds_consola_universal`.`ctUserAreas` (`IdUserArea`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (1, 'admin', 'N', 'Alfredo Barrios', 'alfredo.barrios@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (1, 'chicharron', 'N', 'Javier Hernández', 'javier.hernandez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (2, '12345', 'N', 'Ana Karen Suárez', 'ana.suarez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (3, '12345', 'N', 'Magdalena Rodríguez', 'magdalena.rodriguez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (4, '12345', 'N', 'Luis Regalado', 'luis.regalado@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (5, '12345', 'N', 'Karen López', 'qasupervision@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (6, '12345', 'N', 'Soporte', 'soporte@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsers` (`IdUserArea`, `Password`, `Unavaible`, `Name`, `Email`, `Superuser`) VALUES (7, '12345', 'N', 'Diego Mota', 'diego.mota@speedymovil.com', 'Y');


-- ***************************************************************************************************************************************************************************************
-- ***************************************************************************************************************************************************************************************


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`cfConfiguraciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`cfConfiguraciones` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`cfConfiguraciones` (
  `IdConfiguracion` INT(11) NOT NULL AUTO_INCREMENT,
  `Descripcion` VARCHAR(250) NULL DEFAULT NULL,
  `Valor` VARCHAR(250) NULL DEFAULT NULL,
  PRIMARY KEY (`IdConfiguracion`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctAplicaciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctAplicaciones` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctAplicaciones` (
  `Eliminar` CHAR(1) NOT NULL,
  `IdAplicacion` INT(11) NOT NULL AUTO_INCREMENT,
  `Mostrar` CHAR(1) NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdAplicacion`),
  UNIQUE INDEX `IdAplicacion` (`IdAplicacion` ASC),
  UNIQUE INDEX `Nombre` (`Nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctVersiones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctVersiones` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctVersiones` (
  `Eliminar` CHAR(1) NOT NULL,
  `IdAplicacion` INT(11) NOT NULL,
  `IdVersion` INT(11) NOT NULL AUTO_INCREMENT,
  `Mostrar` CHAR(1) NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `version_base` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`IdVersion`),
  UNIQUE INDEX `IdVersion` (`IdVersion` ASC),
  UNIQUE INDEX `Nombre` (`Nombre` ASC),
  INDEX `IdAplicacion` (`IdAplicacion` ASC),
  INDEX `FK_version_base_ctVersiones` (`version_base` ASC),
  CONSTRAINT `FK_ctVersiones_ctAplicaciones`
    FOREIGN KEY (`IdAplicacion`)
    REFERENCES `bds_consola_universal`.`ctAplicaciones` (`IdAplicacion`),
  CONSTRAINT `FK_version_base_ctVersiones`
    FOREIGN KEY (`version_base`)
    REFERENCES `bds_consola_universal`.`ctVersiones` (`IdVersion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctPaises`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctPaises` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctPaises` (
  `Codigo` VARCHAR(10) NOT NULL,
  `Eliminar` CHAR(1) NOT NULL,
  `idPais` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idPais`),
  UNIQUE INDEX `Codigo` (`Codigo` ASC),
  UNIQUE INDEX `idPais` (`idPais` ASC),
  UNIQUE INDEX `Nombre` (`Nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctPerfiles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctPerfiles` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctPerfiles` (
  `Eliminar` CHAR(1) NOT NULL,
  `idPais` INT(11) NOT NULL,
  `IdPerfil` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IdPerfil`),
  INDEX `idPais` (`idPais` ASC),
  CONSTRAINT `FK_ctPerfiles_ctPaises`
    FOREIGN KEY (`idPais`)
    REFERENCES `bds_consola_universal`.`ctPaises` (`idPais`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`rrAplicacionVersionPais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`rrAplicacionVersionPais` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`rrAplicacionVersionPais` (
  `IdPerfil` INT(11) NOT NULL,
  `IdRelAppPais` INT(11) NOT NULL AUTO_INCREMENT,
  `IdVersion` INT(11) NOT NULL,
  PRIMARY KEY (`IdRelAppPais`),
  INDEX `IdVersion` (`IdVersion` ASC),
  INDEX `IdPerfil` (`IdPerfil` ASC),
  CONSTRAINT `FK_rrAplicacionVer_ctVersiones`
    FOREIGN KEY (`IdVersion`)
    REFERENCES `bds_consola_universal`.`ctVersiones` (`IdVersion`),
  CONSTRAINT `FK_rrAplicacionVers_ctPerfiles`
    FOREIGN KEY (`IdPerfil`)
    REFERENCES `bds_consola_universal`.`ctPerfiles` (`IdPerfil`))
ENGINE = InnoDB
AUTO_INCREMENT = 253
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctCambios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctCambios` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctCambios` (
  `idCambio` INT(11) NOT NULL,
  `IdRelAppPais_base` INT(11) NOT NULL,
  `fecha_hora` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idCambio`, `IdRelAppPais_base`),
  INDEX `IdRelAppPais_cambios_idx` (`IdRelAppPais_base` ASC),
  CONSTRAINT `IdRelAppPais_base_fk`
    FOREIGN KEY (`IdRelAppPais_base`)
    REFERENCES `bds_consola_universal`.`rrAplicacionVersionPais` (`IdRelAppPais`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COMMENT = 'tabla que almacenará un consecutivo de cambio por cada versión asi como la fecha-hora en que se agrega el registro';


-- ***************************************************************************************************************************************************************************************
-- ***************************************************************************************************************************************************************************************
-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctUsuarioAreas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctUsuarioAreas` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctUsuarioAreas` (
  `IdUsuarioArea` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(50) NOT NULL,
  `Notifica` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdUsuarioArea`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Infraestructura', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Negocio', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Desarrollo BE', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Desarrollo Apps', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('QA', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Soporte', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`, `Notifica`) VALUES ('Líder', 'Y');


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ctUsuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ctUsuarios` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ctUsuarios` (
  `IdUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `IdUsuarioArea` INT(11) NOT NULL,
  `Contrasena` VARCHAR(150) NOT NULL,
  `Eliminar` CHAR(1) NOT NULL,
  `Nombre` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(150) NOT NULL,
  `Superusuario` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  CONSTRAINT `FK_Usuario_Area`
    FOREIGN KEY (`IdUsuarioArea`)
    REFERENCES `bds_consola_universal`.`ctUsuarioAreas` (`IdUsuarioArea`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (1, 'admin', 'N', 'Alfredo Barrios', 'alfredo.barrios@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (1, 'chicharron', 'N', 'Javier Hernández', 'javier.hernandez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (2, '12345', 'N', 'Ana Karen Suárez', 'ana.suarez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (3, '12345', 'N', 'Magdalena Rodríguez', 'magdalena.rodriguez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (4, '12345', 'N', 'Luis Regalado', 'luis.regalado@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (5, '12345', 'N', 'Karen López', 'qasupervision@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (6, '12345', 'N', 'Soporte', 'soporte@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (7, '12345', 'N', 'Diego Mota', 'diego.mota@speedymovil.com', 'Y');

-- -----------------------------------------------------
-- Table `bds_consola_universal`.`rpBitacora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`rpBitacora` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`rpBitacora` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Evento` INT(11) NOT NULL,
  `Fechahora` DATE NOT NULL,
  `Aplicacion` VARCHAR(50) NOT NULL,
  `Version` VARCHAR(50) NOT NULL,
  `Pais` VARCHAR(50) NOT NULL,
  `Perfil` VARCHAR(50) NOT NULL,
  `NuevoCambio` CHAR(1) NOT NULL,
  `VersionVersion` VARCHAR(50) NOT NULL,
  `Usuario` VARCHAR(50) NOT NULL,
  `Nodo` VARCHAR(2500) NOT NULL,
  `Requerimiento` VARCHAR(2500) NOT NULL,
  `Release` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;
-- ***************************************************************************************************************************************************************************************
-- ***************************************************************************************************************************************************************************************

-- -----------------------------------------------------
-- Table `bds_consola_universal`.`ftItemsConfiguracion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`ftItemsConfiguracion` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`ftItemsConfiguracion` (
  `IdItemConfiguracion` INT(11) NOT NULL AUTO_INCREMENT,
  `IdRelAppPais` INT(11) NOT NULL,
  `LlavePrivada` VARCHAR(200) NULL DEFAULT NULL,
  `Mostrar` CHAR(1) NOT NULL,
  `MostrarLlavePrivadaEnJSON` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdItemConfiguracion`),
  INDEX `IdRelAppPais` (`IdRelAppPais` ASC),
  INDEX `IdItemConfiguracion` (`IdItemConfiguracion` ASC),
  CONSTRAINT `FK_ftItemsConfig_rrAplicacionV`
    FOREIGN KEY (`IdRelAppPais`)
    REFERENCES `bds_consola_universal`.`rrAplicacionVersionPais` (`IdRelAppPais`))
ENGINE = InnoDB
AUTO_INCREMENT = 19198
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`dtConfigValores`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`dtConfigValores` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`dtConfigValores` (
  `IdConfigValor` INT(11) NOT NULL AUTO_INCREMENT,
  `IdItemConfiguracion` INT(11) NOT NULL,
  `Atributo` VARCHAR(50) NOT NULL,
  `Valor` VARCHAR(2500) NULL DEFAULT NULL,
  `Mostrar` CHAR(1) NOT NULL,
  `SiempreEsArreglo` CHAR(1) NOT NULL,
  PRIMARY KEY (`IdConfigValor`),
  INDEX `IdItemConfiguracion` (`IdItemConfiguracion` ASC),
  CONSTRAINT `FK_dtConfigValor_ftItemsConfig`
    FOREIGN KEY (`IdItemConfiguracion`)
    REFERENCES `bds_consola_universal`.`ftItemsConfiguracion` (`IdItemConfiguracion`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 76091
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`rrAppPaisVSUsuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`rrAppPaisVSUsuarios` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`rrAppPaisVSUsuarios` (
  `IdAppPaisVSUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `IdRelAppPais` INT(11) NOT NULL,
  `IdUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`IdAppPaisVSUsuario`),
  INDEX `IdRelAppPais` (`IdRelAppPais` ASC),
  INDEX `IdUsuario` (`IdUsuario` ASC),
  CONSTRAINT `FK_rrAppPaisVSUs_rrAplicacionP`
    FOREIGN KEY (`IdRelAppPais`)
    REFERENCES `bds_consola_universal`.`rrAplicacionVersionPais` (`IdRelAppPais`),
  CONSTRAINT `FK_rrAppPaisVSUsuar_ctUsuarios`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `bds_consola_universal`.`ctUsuarios` (`IdUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 265
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `bds_consola_universal`.`rrListaItems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bds_consola_universal`.`rrListaItems` ;

CREATE TABLE IF NOT EXISTS `bds_consola_universal`.`rrListaItems` (
  `IdItem` INT(11) NOT NULL AUTO_INCREMENT,
  `IdConfigValor` INT(11) NOT NULL,
  `IdItemConfiguracion` INT(11) NOT NULL,
  PRIMARY KEY (`IdItem`),
  UNIQUE INDEX `IdItem` (`IdItem` ASC),
  INDEX `IdItemConfiguracion` (`IdItemConfiguracion` ASC),
  INDEX `IdConfigValor` (`IdConfigValor` ASC),
  CONSTRAINT `FK_ListaItems_dtConfigValores`
    FOREIGN KEY (`IdConfigValor`)
    REFERENCES `bds_consola_universal`.`dtConfigValores` (`IdConfigValor`)
    ON DELETE CASCADE,
  CONSTRAINT `FK_Lista_VS_Items`
    FOREIGN KEY (`IdItemConfiguracion`)
    REFERENCES `bds_consola_universal`.`ftItemsConfiguracion` (`IdItemConfiguracion`)
    ON DELETE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 14935
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
