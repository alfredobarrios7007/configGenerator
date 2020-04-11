Initialize the project in...
https://start.spring.io/

Place the content of the ZIP file in the src / projects / source directory

---------------------------------------------------------------------

Edit the POM.xml file

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.6.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.koatchy</groupId>
	<artifactId>configGenerator</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>war</packaging>
	<name>Config Generator</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<scope>test</scope>
		</dependency>

		<!-- JPA -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<!-- Web -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<!-- MySQL Connector -->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<scope>runtime</scope>
		</dependency>
		
		<!-- Setters Getters -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

-----------------------------------------------------------------------------------------------------------------
-- Edit the application.properties
#Database connection properties
spring.datasource.url=jdbc:mysql://localhost:3306/bds_consola_universal?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
#Database credentials
spring.datasource.username=root
spring.datasource.password=admin

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true

#The SQL dialect allows Hibernate generate better SQL for the chosen database
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

#Hibernate ddl auto [create, create-drop, validate, update
spring.jpa.hibernate.ddl-auto=none

#Tomcat port
server.port=80

spring.mvc.view.prefix=/jsp/
spring.mvc.view.suffix=.jsp


spring.jpa.open-in-view=false

---------------------------------------------------------------------------------------------------------------------

create the database i.e.

DROP SCHEMA IF EXISTS `bds_consola_universal` ;
CREATE SCHEMA IF NOT EXISTS `bds_consola_universal` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `bds_consola_universal` ;


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


--------------------------------------------------------------------------------------------------------------------------------------------
Create the models

package com.koatchy.configGenerator.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ctusuarioareas")
public class UsuarioArea {

	public UsuarioArea() {}
	
	public UsuarioArea(long id, String nombre, String notifica) {
		this.Id=id;
		this.Nombre=nombre;
		this.Notifica=notifica;
	}
	
	@Id
	@Column(name="idusuarioarea")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="nombre")
	private String Nombre;

	@Column(name="notifica")
	private String Notifica;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getNotifica() {
		return Notifica;
	}

	public void setNotifica(String notifica) {
		Notifica = notifica;
	}

	@Override
	public String toString() {
		return "UsuarioArea [Id=" + Id + ", Nombre=" + Nombre + ", Notifica=" + Notifica + "]";
	}
	
	
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.koatchy.configGenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ctusuarios")
public class Usuario {
	
	public Usuario() {}
	
	public Usuario(long idusuario, long idusuarioarea, String contrasena, String eliminar, String nombre, String email) {
		this.Id = idusuario;
		this.IdUsuarioArea = idusuarioarea;
		this.Contrasena = contrasena;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
		this.Email = email;
	}

	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idusuarioarea")
	private long IdUsuarioArea;
	
	@Column(name="contrasena")
	private String Contrasena;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="email")
	private String Email;
	
	@Column(name="superusuario")
	private String Superusuario;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdUsuarioArea() {
		return IdUsuarioArea;
	}

	public void setIdUsuarioArea(long idUsuarioArea) {
		IdUsuarioArea = idUsuarioArea;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getEliminar() {
		return Eliminar;
	}

	public void setEliminar(String eliminar) {
		Eliminar = eliminar;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSuperusuario() {
		return Superusuario;
	}

	public void setSuperusuario(String superusuario) {
		Superusuario = superusuario;
	}

	@Override
	public String toString() {
		return "Usuario [Id=" + Id + ", IdUsuarioArea=" + IdUsuarioArea + ", Contrasena=" + Contrasena + ", Eliminar="
				+ Eliminar + ", Nombre=" + Nombre + ", Email=" + Email + ", Superusuario=" + Superusuario + "]";
	}	
	
}

-------------------------------------------------------------------------------------------------------------------------------------

Create the DAOs i.e.

package com.koatchy.configGenerator.dao;
import com.koatchy.configGenerator.entity.UsuarioArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAreaDao extends JpaRepository<UsuarioArea, Long>{

}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{

}

--------------------------------------------------------------------------------------------------------------------------------------

Create a model for generic respose i.e.

package com.koatchy.configGenerator.model;

public class GeneralResponse {
	Integer Code = 0;
	String Message = "";
	Object Response = "";
	public Integer getCode() {
		return Code;
	}
	public void setCode(Integer code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Object getResponse() {
		return Response;
	}
	public void setResponse(Object response) {
		Response = response;
	}
	public GeneralResponse() {}
	public GeneralResponse(Integer code, String message) {
		this.Code = code;
		this.Message = message;
	}
	public GeneralResponse(Integer code, String message, Object response) {
		this.Code = code;
		this.Message = message;
		this.Response = response;
	}
}


-----------------------------------------------------------------------------------------------------------------------------------------

Create the interfaces for the services i.e.

package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.UsuarioArea;

/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioAreaService {

	UsuarioArea saveUsuarioArea(UsuarioArea usuario);
	
	UsuarioArea updateUsuarioArea(UsuarioArea usuario);
	
	List<UsuarioArea> getAllUsuarioAreas();
	
	Optional<UsuarioArea> getUsuarioArea(Long IdUsuarioArea);
	
	void deleteUsuarioArea(Long IdUsuarioArea);

}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.Usuario;

/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioService {

	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	List<Usuario> getAllUsuarios();
	
	Optional<Usuario> getUsuario(Long IdUsuario);
	
	void deleteUsuario(Long IdUsuario);
	
}


-------------------------------------------------------------------------------------------------------------------------------------

Create the implementations for the services i.e. 

/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.dao.UsuarioAreaDao;
import com.koatchy.configGenerator.entity.UsuarioArea;


/**
 * @author alfredo.barrios
 *
 */
@Service
public class UsuarioAreaServiceImpl implements UsuarioAreaService {

	@Autowired(required = true)
	private UsuarioAreaDao usuarioAreaDao;	
	
	@Override
	public UsuarioArea saveUsuarioArea(UsuarioArea usuarioArea) {
		return usuarioAreaDao.save(usuarioArea);
	}

	@Override
	public UsuarioArea updateUsuarioArea(UsuarioArea usuarioArea) {
		return usuarioAreaDao.saveAndFlush(usuarioArea);
	}

	@Override
	public List<UsuarioArea> getAllUsuarioAreas() {
		return usuarioAreaDao.findAll();
	}

	@Override
	public Optional<UsuarioArea> getUsuarioArea(Long IdUsuarioArea) {
		return usuarioAreaDao.findById(IdUsuarioArea);
	}

	@Override
	public void deleteUsuarioArea(Long IdUsuarioArea) {
		usuarioAreaDao.deleteById(IdUsuarioArea);
	}

}

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.dao.UsuarioDao;
import com.koatchy.configGenerator.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired(required = true)
	private UsuarioDao usuarioDao;	
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDao.saveAndFlush(usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioDao.findAll();
	}

	@Override
	public Optional<Usuario> getUsuario(Long IdUsuario) {
		return usuarioDao.findById(IdUsuario);
	}

	@Override
	public void deleteUsuario(Long IdUsuario) {
		usuarioDao.deleteById(IdUsuario);
	}

}
------------------------------------------------------------------------------------------------
Create the rest service i.e.

/**
 * 
 */
package com.koatchy.configGenerator.controller;

/**
 * @author alfredo.barrios
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.entity.UsuarioArea;
import com.koatchy.configGenerator.service.UsuarioAreaService;
import com.koatchy.configGenerator.service.UsuarioAreaServiceImpl;

@RequestMapping("UsuarioArea")
@RestController
public class UsuarioAreaController {
	
	@Autowired
	private UsuarioAreaService usuarioAreaServ;
	
	@PostMapping("save")
	public UsuarioArea save(@RequestBody UsuarioArea usuarioArea) {
		System.out.println("save");
		return usuarioAreaServ.saveUsuarioArea(usuarioArea);
	}
	
	@PutMapping("/update")
	public UsuarioArea update(@RequestBody UsuarioArea usuarioArea) {
		System.out.println("update");
		return usuarioAreaServ.updateUsuarioArea(usuarioArea);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllUsuarioAreas(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", usuarioAreaServ.getAllUsuarioAreas());
	}
	
	@GetMapping("/by/{IdUsuarioArea}")
	public GeneralResponse getUsuarioArea(@PathVariable(name = "IdUsuarioArea") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", usuarioAreaServ.getUsuarioArea(Id));
	}

	@GetMapping("/delete/{IdUsuarioArea}")
	public GeneralResponse deleteUsuarioArea(@PathVariable(name = "IdUsuarioArea") Long Id) {
		System.out.println("delete");
		usuarioAreaServ.deleteUsuarioArea(Id);
		return new GeneralResponse(200, "Success");		
	}
	
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

package com.koatchy.configGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.entity.Usuario;
import com.koatchy.configGenerator.service.UsuarioService;
import com.koatchy.configGenerator.service.UsuarioServiceImpl;

@RequestMapping("Usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@PostMapping("save")
	public Usuario save(@RequestBody Usuario usuario) {
		System.out.println("save: " + usuario.toString());
		return usuarioServ.saveUsuario(usuario);
	}
	
	@PutMapping("/update")
	public Usuario update(@RequestBody Usuario usuario) {
		System.out.println("update");
		return usuarioServ.updateUsuario(usuario);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllUsuarios(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", usuarioServ.getAllUsuarios());
	}
	
	@GetMapping("/by/{IdUsuario}")
	public GeneralResponse getUsuario(@PathVariable(name = "IdUsuario") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", usuarioServ.getUsuario(Id));
	}

	@GetMapping("/delete/{IdUsuario}")
	public GeneralResponse deleteUsuario(@PathVariable(name = "IdUsuario") Long Id) {
		System.out.println("delete");
		usuarioServ.deleteUsuario(Id);
		return new GeneralResponse(200, "Success");		
	}
	
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

}

---------------------------------------------------------------------------------------------------------------------------

Use Postman to invoke the rest services i.e.

GET http://localhost/Usuario/all

POST http://localhost/Usuario/save

Body
{
"id": 8,
"idUsuarioArea": 2,
"eliminar": "N",
"contrasena": "Jioids97k_",
"nombre": "Kamikaze XXX",
"email": "kamikaze@speedymovil.com",
"superusuario": "N"
}



PUT http://localhost/Usuario/update

Body
{
"id": 8,
"idUsuarioArea": 2,
"eliminar": "N",
"contrasena": "Jioids97k_",
"nombre": "Kamikaze ZZZ",
"email": "kamikaze@speedymovil.com",
"superusuario": "S"
}

