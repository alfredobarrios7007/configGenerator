-- Wed Oct 8 20:32:00 2019
-- Model: abcCRM Version: 1.0
-- Designed by: Alfredo Barrios

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_abc_CRM_base
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `db_abc_CRM_base` ;

-- -----------------------------------------------------
-- Schema db_abc_CRM_base
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_abc_CRM_base` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `db_abc_CRM_base` ;

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctUsuarioAreas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctUserTypes` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctUserTypes` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Superuser');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Infraestructura');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Negocio');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Desarrollo BE');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Desarrollo Apps');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('QA');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Soporte');
INSERT INTO `db_abc_CRM_base`.`ctUserTypes` (`Name`) VALUES ('Líder');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctUsers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctUsers` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctUsers` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(150) NOT NULL,
  `Username` VARCHAR(150) NOT NULL,
  `Password` VARCHAR(150) NOT NULL,
  `Active` BOOLEAN NOT NULL,
  `Created_At` Datetime NOT NULL,
  `Created_By` VARCHAR(80) NOT NULL,
  `Updated_At` Datetime NULL,
  `Updated_By` VARCHAR(80) NULL,
  PRIMARY KEY (`Id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `db_abc_CRM_base`.`ctUsers` (`Name`,`Email`,`Username`,`Password`,`Active`,`Created_At`,`Created_By`) VALUES ('Administrator', 'alfredo_barrios_cruz@hotmail.fr','admin','admin',1, sysdate(), 'CREATION');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctUserByTypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctUserByTypes` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctUserByTypes` (
  `UserId` INT(11) NOT NULL,
  `UserTypeId` INT(11) NOT NULL,
  PRIMARY KEY (`UserId`,`UserTypeId`),
  CONSTRAINT `FK_Users_Types`
    FOREIGN KEY (`UserTypeId`)
    REFERENCES `db_abc_CRM_base`.`ctUserTypes` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_Users`
    FOREIGN KEY (`UserId`)
    REFERENCES `db_abc_CRM_base`.`ctUsers` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION
	)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `db_abc_CRM_base`.`ctUserByTypes` (`UserId`,`UserTypeId`) VALUES (1, 1);


-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`cfConfiguraciones`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`cfConfiguraciones` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`cfConfiguraciones` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(250) NOT NULL,
  `Value` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

INSERT INTO `db_abc_CRM_base`.`cfConfiguraciones` (`Description`, `Value`) VALUES ('OWNER CRM', 'Comercializadora, S.A. de C.V.');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctIndustry`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctIndustries` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctIndustries` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Actividades legislativas, gubernamentales, de impartición de justicia y de organismos internacionales y extraterritoriales');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Comercio al por mayor');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Comercio al por menor');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Construcción');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Corporativos');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Generación, transmisión, distribución y comercialización de energía eléctrica, suministro de agua y de gas natural por ductos al consumidor final');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Agricultura, cría y explotación de animales, aprovechamiento forestal, pesca y caza');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Industrias manufactureras');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Información en medios masivos');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Minería');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Otros servicios excepto actividades gubernamentales');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios de alojamiento temporal y de preparación de alimentos y bebidas');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios de apoyo a los negocios y manejo de residuos, y servicios de remediación');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios de esparcimiento culturales y deportivos, y otros servicios recreativos');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios de salud y de asistencia social');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios educativos');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios financieros y de seguros');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios inmobiliarios y de alquiler de bienes muebles e intangibles');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Servicios profesionales, científicos y técnicos');
INSERT INTO `db_abc_CRM_base`.`ctIndustries` (`Name`) VALUES ('Transportes, correos y almacenamiento');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctCountries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctCountries` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctCountries` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

INSERT INTO `db_abc_CRM_base`.`ctCountries` (`Name`) VALUES ('México');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctSuppliers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctSuppliers` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctSuppliers` (
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(500) NOT NULL,
  `Nickname` VARCHAR(50) NOT NULL,
  `PublicEstateID` VARCHAR(25) NOT NULL, -- RFC RUT
  `IndustryId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `FK_ctIndustries_ctSuppliers`
    FOREIGN KEY (`IndustryId`)
    REFERENCES `db_abc_CRM_base`.`ctIndustries` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctCustumers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctCustumers` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctCustumers` (
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(500) NOT NULL,
  `Nickname` VARCHAR(50) NOT NULL,
  `PublicEstateID` VARCHAR(25) NOT NULL, -- RFC RUT
  `IndustryId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `FK_ctIndustries_ctCustumers`
    FOREIGN KEY (`IndustryId`)
    REFERENCES `db_abc_CRM_base`.`ctIndustries` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`sctAddresses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`sctAddresses` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`sctAddresses` (
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(500) NOT NULL,
  `Nickname` VARCHAR(50) NOT NULL,
  `Fiscal` BOOLEAN NOT NULL,
  `MainDelivery` BOOLEAN NOT NULL,
  `Street` VARCHAR(50) NOT NULL,
  `ExteriorNumber` VARCHAR(10) NOT NULL,
  `InteriorNumber` VARCHAR(10) NOT NULL,
  `Neighbornhood` VARCHAR(50) NOT NULL,
  `City` VARCHAR(50) NOT NULL,
  `State` VARCHAR(50) NOT NULL,
  `CountryId` INT NOT NULL,
  `CustomerId` BIGINT NULL,
  `SupplierId` BIGINT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `FK_ctSuppliers_sctAddresses`
    FOREIGN KEY (`SupplierId`)
    REFERENCES `db_abc_CRM_base`.`ctSuppliers` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ctCustomers_sctAddresses`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `db_abc_CRM_base`.`ctCustomers` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ctCountries_sctAddresses`
    FOREIGN KEY (`CountryId`)
    REFERENCES `db_abc_CRM_base`.`ctCountries` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`ctContactTypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`ctContactTypes` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`ctContactTypes` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

INSERT INTO `db_abc_CRM_base`.`ctContactTypes` (`Name`) VALUES ('Vendedor');
INSERT INTO `db_abc_CRM_base`.`ctContactTypes` (`Name`) VALUES ('Comprador');
INSERT INTO `db_abc_CRM_base`.`ctContactTypes` (`Name`) VALUES ('Sistemas');
INSERT INTO `db_abc_CRM_base`.`ctContactTypes` (`Name`) VALUES ('Almacen');

-- -----------------------------------------------------
-- Table `db_abc_CRM_base`.`sctContacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `db_abc_CRM_base`.`sctContacts` ;

CREATE TABLE IF NOT EXISTS `db_abc_CRM_base`.`sctContacts` (
  `Id` BIGINT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(500) NOT NULL,
  `Lastname` VARCHAR(500) NOT NULL,
  `Nickname` VARCHAR(50) NOT NULL,
  `Email` VARCHAR(250) NOT NULL,
  `Notes` Text NOT NULL,
  `CustomerId` BIGINT NULL,
  `SupplierId` BIGINT NULL,
  `ContactTypeId` INT NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `FK_ctSuppliers_ctContactTypes`
    FOREIGN KEY (`ContactTypeId`)
    REFERENCES `db_abc_CRM_base`.`ctContactTypes` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ctSuppliers_sctContacts`
    FOREIGN KEY (`SupplierId`)
    REFERENCES `db_abc_CRM_base`.`ctSuppliers` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_ctCustomers_sctContacts`
    FOREIGN KEY (`CustomerId`)
    REFERENCES `db_abc_CRM_base`.`ctCustomers` (`Id`)
	ON DELETE  CASCADE
    ON UPDATE NO ACTION
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
