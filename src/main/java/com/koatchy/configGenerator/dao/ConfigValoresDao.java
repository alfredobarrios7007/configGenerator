package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.ConfigValores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigValoresDao extends JpaRepository<ConfigValores, Long>{

}
