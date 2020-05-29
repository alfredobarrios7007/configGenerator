package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	@Query(
			value = "SELECT Idusuario, IdUsuarioArea, Eliminar, Contrasena, Nombre, Email, Superusuario FROM ctusuarios  WHERE Eliminar='N' AND Email = :username and Contrasena = :password", 
			nativeQuery = true)
	Optional<Usuario> findUserByNameAndPassword(@Param("username")String username, @Param("password") String password);

	@Query(
			value = "SELECT Idusuario, IdUsuarioArea, Eliminar, Contrasena, Nombre, Email, Superusuario FROM ctusuarios  WHERE Eliminar='N' AND Email = :email", 
			nativeQuery = true)
	Optional<Usuario> findUserByEmail(@Param("email")String email);
	
}
