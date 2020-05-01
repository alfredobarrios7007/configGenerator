package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitacoraDao extends JpaRepository<Bitacora, Long>{

}
