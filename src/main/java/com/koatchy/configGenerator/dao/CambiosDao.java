package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Cambios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambiosDao extends JpaRepository<Cambios, Long>{

}
