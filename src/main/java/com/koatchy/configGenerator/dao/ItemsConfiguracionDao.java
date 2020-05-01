package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.ItemsConfiguracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsConfiguracionDao extends JpaRepository<ItemsConfiguracion, Long>{

}
