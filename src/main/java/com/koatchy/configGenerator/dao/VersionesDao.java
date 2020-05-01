package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Versiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionesDao extends JpaRepository<Versiones, Long>{

}
