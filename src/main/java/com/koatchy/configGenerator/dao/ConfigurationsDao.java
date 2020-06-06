/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface ConfigurationsDao extends JpaRepository<Configuration, Long>{

}
