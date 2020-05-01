package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.Perfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilesDao extends JpaRepository<Perfiles, Long>{

}
