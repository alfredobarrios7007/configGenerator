package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Configuraciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionesDao extends JpaRepository<Configuraciones, Long>{

}
