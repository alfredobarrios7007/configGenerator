package com.koatchy.configGenerator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="ctperfiles")
public class Perfiles  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Perfiles() {}

	/*
	public Perfiles(long id, String eliminar, String nombre, Paises pais) {
		this.Id = id;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
		this.pais = pais;
	}
	*/
	public Perfiles(long id, String eliminar, String nombre) {
		this.Id = id;
		this.Nombre = nombre;
		this.Eliminar = eliminar;
	}

	@Id
	@Column(name="idperfil")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="idpais")
	private String IdPais;
		
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getEliminar() {
		return Eliminar;
	}

	public void setEliminar(String eliminar) {
		Eliminar = eliminar;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getIdPais() {
		return IdPais;
	}

	public void setIdPais(String idPais) {
		IdPais = idPais;
	}
	
	
	
	/*	
    @ManyToOne
    @JoinColumn (name="idpais")
    private Paises pais;

	@Override
	public String toString() {
		return String.format("Perfiles [Id=%i, Eliminar=%e, Nombre=%n, Pais=%p]", this.Id, this.Eliminar, this.Nombre, this.pais.getId());
	}
    public Paises getPais() {
        return pais;
    }
 
    public void setPais(Paises pais) {
        this.pais = pais;
    }	
	 */
	
}
