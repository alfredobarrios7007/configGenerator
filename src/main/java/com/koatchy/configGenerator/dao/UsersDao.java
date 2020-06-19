/**
 * 
 */
package com.koatchy.configGenerator.dao;
import com.koatchy.configGenerator.entity.User;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface UsersDao extends JpaRepository<User, Long>{
	@Query(
			value = "SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  WHERE Unavaibled='N' AND :email = Email AND :password = Password ", 
			nativeQuery = true)
	Optional<User> findUserByNameAndPassword(@Param("email")String email, @Param("password") String password);

	@Query(
			value = "SELECT iduser,iduserarea,idorganization,idorganizationrol,password,name,lastname,email,superuser,photo,unavaibled,created_datetime,created_platform,updated_datetime,updated_platform FROM ctusers  WHERE Unavaibled='N' AND :email = Email ", 
			nativeQuery = true)
	Optional<User> findUserByEmail(@Param("email")String email);
	

	@Modifying
    @Transactional
    @Query(
			value = "UPDATE ctusers SET Password=:password WHERE Email = :email", 
			nativeQuery = true)
	int setNewPassword(@Param("email")String email, @Param("password") String password);

}
