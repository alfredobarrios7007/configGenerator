/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Configuration;

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
public interface ConfigurationsDao extends JpaRepository<Configuration, Long>{
	@Query(
			value = "SELECT idconfiguration,description,valueof FROM cfconfigurations WHERE :key = description", nativeQuery = true)
	Optional<Configuration> findByDescription(@Param("key")String description);

}
