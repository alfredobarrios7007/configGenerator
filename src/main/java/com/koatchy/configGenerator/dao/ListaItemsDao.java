package com.koatchy.configGenerator.dao;

import com.koatchy.configGenerator.entity.ListaItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaItemsDao extends JpaRepository<ListaItems, Long>{

}
