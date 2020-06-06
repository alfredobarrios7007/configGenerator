/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface AddressesDao extends JpaRepository<Address, Long>{

}
