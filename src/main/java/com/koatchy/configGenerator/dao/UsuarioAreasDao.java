package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.UsuarioAreas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAreasDao extends JpaRepository<UsuarioAreas, Long>{

}
