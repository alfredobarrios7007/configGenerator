USE `world` ;
USE `db_abc_crm_base` ;

SELECT * FROM ctusers;
SELECT * FROM city;
SELECT * FROM country;
SELECT * FROM countrylanguage;
SELECT * FROM ctPerfiles;

-- Para evitar el error en java: "The server time zone value 'Hora est ndar central..."
SET GLOBAL time_zone = '-3:00';

SELECT curdate();
SELECT curtime();

INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Infraestructura');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Negocio');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Desarrollo BE');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Desarrollo Apps');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('QA');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Soporte');
INSERT INTO `bds_consola_universal`.`ctUsuarioAreas` (`Nombre`) VALUES ('Líder');

INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (1, 'admin', 'N', 'Alfredo Barrios', 'alfredo.barrios@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (1, 'chicharron', 'N', 'Javier Hernández', 'javier.hernandez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (2, '12345', 'N', 'Ana Karen Suárez', 'ana.suarez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (3, '12345', 'N', 'Magdalena Rodríguez', 'magdalena.rodriguez@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (4, '12345', 'N', 'Luis Regalado', 'luis.regalado@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (5, '12345', 'N', 'Karen López', 'qasupervision@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (6, '12345', 'N', 'Soporte', 'soporte@speedymovil.com', 'Y');
INSERT INTO `bds_consola_universal`.`ctUsuarios` (`IdUsuarioArea`, `Contrasena`, `Eliminar`, `Nombre`, `Email`, `Superusuario`) VALUES (7, '12345', 'N', 'Diego Mota', 'diego.mota@speedymovil.com', 'Y');


ALTER TABLE `bds_consola_universal`.`ctAplicaciones` ADD COLUMN `URL` VARCHAR(1000);
SELECT * FROM `bds_consola_universal`.`ctAplicaciones`;
SELECT * FROM `bds_consola_universal`.`ctUsuarioAreas`;
SELECT * FROM `bds_consola_universal`.`ctUsuarios`;
SELECT * FROM `bds_consola_universal`.`ctUsuarioAreas` areas INNER JOIN `bds_consola_universal`.`ctUsuarios` usua ON areas.IdUsuarioArea=usua.IdUsuarioArea;

