package com.koatchy.configGenerator.dao;
import com.koatchy.configGenerator.entity.Aplicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AplicacionesDao extends JpaRepository<Aplicaciones, Long>{

}
