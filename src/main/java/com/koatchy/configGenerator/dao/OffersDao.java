/**
 * 
 */
package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author alfredo.barrios
 *
 */
@Repository
public interface OffersDao extends JpaRepository<Offer, Long>{

}
