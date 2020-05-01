package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.AplicacionVersionPais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacionVersionPaisDao extends JpaRepository<AplicacionVersionPais, Long>{

}
