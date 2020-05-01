package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.AppPaisVsUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppPaisVsUsuariosDao extends JpaRepository<AppPaisVsUsuarios, Long>{

}
