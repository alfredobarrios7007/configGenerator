package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ListaItemsService {

	ListaItems save(ListaItems param);
	
	ListaItems update(ListaItems param);
	
	List<ListaItems> getAllRows();
	
	Optional<ListaItems> getRow(Long param);
	
	void deleteRow(Long param);
	
}
