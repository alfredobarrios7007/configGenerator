package com.koatchy.configGenerator.dao;
 
import com.koatchy.configGenerator.entity.RegisterStoredProcedure;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure; 
import org.springframework.data.repository.query.Param; 

/**
 * @author alfredo.barrios
 *
 */

@Repository 
public interface RegisterStoredProcDao extends JpaRepository<RegisterStoredProcedure, Long> {
    @Procedure(name = "register")
    void register(
    		@Param("p_platform") String platform,
    		@Param("p_name") String name,
    		@Param("p_lastname") String lastname,
    		@Param("p_organization") String organization,
    		@Param("p_area") String area,
    		@Param("p_email") String email,
    		@Param("p_password") String password
    		);
}
