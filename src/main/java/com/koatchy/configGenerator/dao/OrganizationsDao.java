/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface OrganizationsDao extends JpaRepository<Organization, Long>{

}
