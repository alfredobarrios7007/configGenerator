/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface CountriesDao extends JpaRepository<Country, Long>{

}
