package com.koatchy.configGenerator;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.service.*;

public class JpaApplicationTest {

	public void contextLoad() {
		PaisesService paisSrv = new PaisesServiceImpl(); 
		Optional<Paises> paiss = paisSrv.getRow(18L);
		
		if(paiss.isPresent()) {
			System.out.print(paiss.toString());
		}
		
		List<Paises> paises = paisSrv.getAllRows();
		for(Paises pais : paises) {
			System.out.print(pais.toString());
		}
	}
}
