package com.koatchy.configGenerator.dao;
import com.koatchy.configGenerator.entity.UsuarioArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAreaDao extends JpaRepository<UsuarioArea, Long>{

}
