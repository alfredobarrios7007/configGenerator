USE sandboxscheme;

DROP TABLE `sandboxscheme`.`ThirdSusbcriptor`;
CREATE TABLE IF NOT EXISTS `sandboxscheme`.`ThirdSusbcriptor` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `ProductoId` VARCHAR(50) NOT NULL,
  `Subscription` VARCHAR(150) NOT NULL,
  `CallCenter` VARCHAR(150) NOT NULL,
  `CompanyName` VARCHAR(150) NOT NULL,
  `Comment` VARCHAR(250) NOT NULL,
  `Active` BOOLEAN NOT NULL,
  `Comment_Upload` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY(`ProductoId`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

DROP TABLE IF EXISTS `sandboxscheme`.`MCErrors`;
CREATE TABLE IF NOT EXISTS `sandboxscheme`.`MCErrors` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Package` VARCHAR(50) NOT NULL,
  `Country` CHAR(2) NOT NULL,
  `OperativeSys` VARCHAR(10) NOT NULL,
  `OperativeSysVersion` VARCHAR(10) NOT NULL,
  `AppVersion` VARCHAR(10) NOT NULL,
  `CodeVersion` VARCHAR(10) NOT NULL,
  `AppDatetime` DATETIME NOT NULL,
  `ServerDatetime` DATETIME DEFAULT CURRENT_TIMESTAMP,
  `Username` VARCHAR(50) NOT NULL,
  `ViewName` VARCHAR(50) NOT NULL,
  `ErrorType` VARCHAR(10) NOT NULL,
  `EndPoint` VARCHAR(100) NOT NULL,
  `AdaptadorMobileFirst` VARCHAR(250) NOT NULL,
  `ServiceName` VARCHAR(20) NOT NULL,
  `ErrorResponse` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`Id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_Package(Package);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_Country(Country);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_OperativeSys(OperativeSys);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_AppVersion(AppVersion);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_AppDatetime(AppDatetime);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_ErrorType(ErrorType);
Alter Table `sandboxscheme`.`MCErrors` ADD Index IdxMCError_ServiceName(ServiceName);


SELECT * FROM `sandboxscheme`.`MCErrors`;


SELECT * FROM cfConfiguraciones;


SELECT * FROM ctPaises;
SELECT * FROM ctPerfiles;

Insert into ctPaises set Nombre='México', Eliminar='N', Codigo='MX';
Insert into ctPerfiles set Nombre='GENERAL', Eliminar='N', idPais=18;





Select Idusuario, IdUsuarioArea, Contrasena, Eliminar, Nombre, Email, Superusuario from bds_consola_universal.ctusuarios;


Select * from ctUsuarioAreas;


INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (7, '12345', 'N', 'Diego Mota', 'diego.mota@speedymovil.com', 'Y');


DROP TABLE `sandboxscheme`.`Clients`;
CREATE TABLE IF NOT EXISTS `sandboxscheme`.`Clients` (
  `Id` CHAR(36) NOT NULL ,
  `Name` VARCHAR(100) NOT NULL,
  `Active` CHAR(1) NOT NULL,
  PRIMARY KEY (`Id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

DROP TABLE `sandboxscheme`.`Configurations`;
CREATE TABLE IF NOT EXISTS `sandboxscheme`.`Configurations` (
  `Id` INT(11) NOT NULL AUTO_INCREMENT,
  `Description` VARCHAR(200) NOT NULL,
  `Value` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`Id`)
  )
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;

