package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Paises;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisesDao extends JpaRepository<Paises, Long>{

}
