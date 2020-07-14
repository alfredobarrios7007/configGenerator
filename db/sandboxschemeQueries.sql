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




SELECT * FROM cfConfiguraciones;


SELECT * FROM ctPaises;
SELECT * FROM ctPerfiles;

Insert into ctPaises set Nombre='México', Eliminar='N', Codigo='MX';
Insert into ctPerfiles set Nombre='GENERAL', Eliminar='N', idPais=18;





Select Idusuario, IdUsuarioArea, Contrasena, Eliminar, Nombre, Email, Superusuario from bds_consola_universal.ctusuarios;


Select * from ctUsuarioAreas;


INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (7, '12345', 'N', 'Diego Mota', 'diego.mota@speedymovil.com', 'Y');


