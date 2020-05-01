package com.koatchy.configGenerator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name="ctperfiles")
public class Perfiles {
	
	public Perfiles() {}
	
	public Perfiles(long id, long idpais, String eliminar, String nombre) {
		this.Id = id;
		this.IdPais = idpais;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
	}

	@Id
	@Column(name="idperfil")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="idpais")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long IdPais;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;

	@Override
	public String toString() {
		return "Perfiles [Id=" + Id + ", IdPais=" + IdPais + ", Eliminar=" + Eliminar + ", Nombre=" + Nombre + "]";
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getIdPais() {
		return IdPais;
	}

	public void setIdPais(long idpais) {
		IdPais = idpais;
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
	
}
