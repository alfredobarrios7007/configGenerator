/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Project;
import com.koatchy.configGenerator.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface ProjectsDao extends JpaRepository<Project, Long>{
	@Query(
			value = "SELECT " +
					" prjs.idproject,prjs.name,prjs.description,prjs.iconurl,prjs.badgeurl,prjs.created_datetime,prjs.created_platform,prjs.updated_datetime,prjs.updated_datetime,prjs.updated_platform  " +
					" FROM ctProjects prjs " + 
					" INNER JOIN rrCompaniesProjects rrcp ON prjs.idproject=rrcp.idproject AND rrcp.Unavaibled='N' " + 
					" INNER JOIN ctUsers usrs ON rrcp.IdCompany=usrs.IdUser " + 
					" WHERE :id = usrs.IdUser ", 
			nativeQuery = true)
	Optional<User> findProjectsByUser(@Param("id")Long id);
	
	@Query(
	value = "SELECT " +
			" prjs.idproject,prjs.name,prjs.description,prjs.iconurl,prjs.badgeurl,prjs.created_datetime,prjs.created_platform,prjs.updated_datetime,prjs.updated_datetime,prjs.updated_platform  " +
			" FROM ctProjects prjs " + 
			" INNER JOIN rrCompaniesProjects rrcp ON prjs.idproject=rrcp.idproject AND rrcp.Unavaibled='N' " + 
			" WHERE :id = rrcp.IdOrganization ", 
	nativeQuery = true)
	Optional<User> findProjectsByOrganization(@Param("id")Long id);

}
