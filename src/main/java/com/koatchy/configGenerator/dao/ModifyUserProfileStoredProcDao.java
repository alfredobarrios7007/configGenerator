package com.koatchy.configGenerator.dao;
 
import com.koatchy.configGenerator.entity.ModifyUserProfileStoredProcedure;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.query.Procedure; 
import org.springframework.data.repository.query.Param; 

/**
 * @author alfredo.barrios
 *
 */

@Repository 
public interface ModifyUserProfileStoredProcDao extends JpaRepository<ModifyUserProfileStoredProcedure, Long> {
    @Procedure(name = "modifyuserprofile")
    void modifyuserprofile(
    		@Param("p_iduser") Integer iduser,
    		@Param("p_platform") String platform,
    		@Param("p_name") String name,
    		@Param("p_lastname") String lastname,
    		@Param("p_enabled") String enabled,
    		@Param("p_organization") String organization,
    		@Param("p_organizationrole") String organizationrole,
    		@Param("p_area") String area,
    		@Param("p_email") String email,
    		@Param("p_superuser") String superuser
    		);
}
