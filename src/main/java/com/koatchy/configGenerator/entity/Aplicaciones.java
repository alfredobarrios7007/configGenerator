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
@Table(name="ctaplicaciones")
public class Aplicaciones {
	
	public Aplicaciones() {}
	
	public Aplicaciones(long id, String eliminar, String nombre, String mostrar) {
		this.Id = id;
		this.Eliminar = eliminar;
		this.Nombre = nombre;
		this.Mostrar = mostrar;
	}

	@Id
	@Column(name="idaplicacion")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="eliminar")
	private String Eliminar;
	
	@Column(name="nombre")
	private String Nombre;
	
	@Column(name="mostrar")
	private String Mostrar;

	@Override
	public String toString() {
		return "Aplicaciones [Id=" + Id + ", Eliminar=" + Eliminar + ", Nombre=" + Nombre + ", Mostrar=" + Mostrar
				+ "]";
	}

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

	public String getMostrar() {
		return Mostrar;
	}

	public void setMostrar(String mostrar) {
		Mostrar = mostrar;
	}
		
}
